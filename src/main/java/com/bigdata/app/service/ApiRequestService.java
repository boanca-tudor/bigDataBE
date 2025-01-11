package com.bigdata.app.service;

import com.bigdata.app.dto.api.WeatherApiResponse;
import com.bigdata.app.entity.WeatherData;
import com.bigdata.app.kafka.producer.WeatherDataProducer;
import com.bigdata.app.mapper.WeatherDataMapper;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
public class ApiRequestService {
    @Value("${weather.api.key}")
    protected String apiKey;

    @Value("${weather.api.lat}")
    protected Float lat;

    @Value("${weather.api.lon}")
    protected Float lon;

    @Value("${weather.kafka.topic}")
    protected String kafkaTopic;

    @Autowired
    protected WeatherDataProducer producer;

    @Scheduled(fixedDelay = 3000)
    public void getWeatherApiData() {
        WebClient.create("https://api.openweathermap.org/data/2.5")
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("appid", apiKey)
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .build())
                .retrieve()
                .bodyToMono(WeatherApiResponse.class)
                .doOnNext(weatherData -> {
                    System.out.println("Fetched Weather Data: " + weatherData);
                    WeatherData newWeather = WeatherDataMapper.fromDto(weatherData);
                    newWeather.setId(Uuids.timeBased());
                    newWeather.setTimestamp(LocalDateTime.now().toString());
                    System.out.println("Sent Data to Kafka Topic: " + kafkaTopic);
                })
                .subscribe();
    }
}
