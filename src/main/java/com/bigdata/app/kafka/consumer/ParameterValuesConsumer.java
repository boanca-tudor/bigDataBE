package com.bigdata.app.kafka.consumer;

import com.bigdata.app.entity.ParameterValues;
import com.bigdata.app.repo.ParameterValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParameterValuesConsumer {
    @Autowired
    protected ParameterValuesRepository parameterValuesRepository;

    @KafkaListener(topics = "${weather.kafka.param-values-topic}", groupId = "param-values-consumer-group",
            containerFactory = "kafkaParamValuesListenerContainerFactory")
    public void listenForParamValuesUpdate(ParameterValues newParamValues) {
        System.out.println("Received parameter update: " + newParamValues);

        // Get the existing single entry
        Optional<ParameterValues> existingParams = parameterValuesRepository.findById("singleton");

        if (existingParams.isPresent()) {
            ParameterValues existing = existingParams.get();

            // Update min/max values
            existing.setTemperatureMin(Math.min(existing.getTemperatureMin(), newParamValues.getTemperatureMin()));
            existing.setTemperatureMax(Math.max(existing.getTemperatureMax(), newParamValues.getTemperatureMax()));

            existing.setWindSpeedMin(Math.min(existing.getWindSpeedMin(), newParamValues.getWindSpeedMin()));
            existing.setWindSpeedMax(Math.max(existing.getWindSpeedMax(), newParamValues.getWindSpeedMax()));

            existing.setRainProbabilityMin(Math.min(existing.getRainProbabilityMin(), newParamValues.getRainProbabilityMin()));
            existing.setRainProbabilityMax(Math.max(existing.getRainProbabilityMax(), newParamValues.getRainProbabilityMax()));

            // Save the updated values back to Cassandra
            parameterValuesRepository.save(existing);
            System.out.println("Updated parameter values.");
        } else {
            // If no record exists, create one
            newParamValues.setKey("singleton"); // Set the fixed key
            parameterValuesRepository.save(newParamValues);
            System.out.println("Created new parameter values.");
        }
    }
}
