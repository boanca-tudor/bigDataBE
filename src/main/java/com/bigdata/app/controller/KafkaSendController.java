package com.bigdata.app.controller;

import com.bigdata.app.dto.api.WeatherApiResponse;
import com.bigdata.app.entity.WeatherData;
import com.bigdata.app.kafka.producer.WeatherDataProducer;
import com.bigdata.app.mapper.WeatherDataMapper;
import com.bigdata.app.repo.WeatherDataRepo;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaSendController {

    @Autowired
    private WeatherDataProducer weatherDataProducer;

    @Autowired
    private WeatherDataRepo repo;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") WeatherApiResponse message) {
        weatherDataProducer.sendMessage("big-data", message);
        return "Message sent: " + message;
    }

    @PostMapping("/sendSample")
    public String sendSample(@RequestBody JsonNode node) {
        WeatherData data = WeatherDataMapper.mapJsonToObject(node);
        repo.insert(data);
        return "Da";
    }
}
