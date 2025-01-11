package com.bigdata.app.kafka.producer;

import com.bigdata.app.dto.ParamValues;
import com.bigdata.app.entity.ParameterValues;
import com.bigdata.app.mapper.ParameterValuesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ParamValuesProducer {

    @Autowired
    private KafkaTemplate<String, ParameterValues> kafkaTemplate;

    @Value("${weather.kafka.param-values-topic}")
    private String paramValuesTopic;

    public void sendParamValues(ParamValues paramValues) {
        ParameterValues values = ParameterValuesMapper.fromDto(paramValues);

        kafkaTemplate.send(paramValuesTopic, values);
        System.out.println("Sent parameter update to Kafka: " + values);
    }
}
