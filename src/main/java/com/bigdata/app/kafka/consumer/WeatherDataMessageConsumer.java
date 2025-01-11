package com.bigdata.app.kafka.consumer;

import com.bigdata.app.dto.api.WeatherApiResponse;
import com.bigdata.app.entity.WeatherData;
import com.bigdata.app.mapper.WeatherDataMapper;
import com.bigdata.app.service.WeatherDataService;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataMessageConsumer {
    @Autowired
    protected WeatherDataService weatherDataService;

    protected boolean canConsume = true;

    @KafkaListener(topics = "${weather.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(WeatherApiResponse data) {
        if (!canConsume) {
            System.out.println("Skipping message due to throttling");
            return; // Skip processing if we are within the interval
        }
        System.out.println("Received message: " + data.getName());

        WeatherData newWeather = WeatherDataMapper.fromDto(data);
        newWeather.setId(Uuids.timeBased());
        weatherDataService.createWeatherData(newWeather);

        System.out.println("Saved data to Cassandra for city:" + data.getName());
    }

    @Scheduled(fixedDelay = 15000)
    public void allowConsumption() {
        canConsume = true;
    }

    public void stopConsumption() {
        canConsume = false;
    }
}
