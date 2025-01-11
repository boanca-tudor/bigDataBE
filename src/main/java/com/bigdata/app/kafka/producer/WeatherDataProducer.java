package com.bigdata.app.kafka.producer;

import com.bigdata.app.dto.api.WeatherApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WeatherDataProducer {

    @Autowired
    private KafkaTemplate<String, WeatherApiResponse> kafkaTemplate;

    public void sendMessage(String topic, WeatherApiResponse message) {
        kafkaTemplate.send(topic, message);
    }
}
