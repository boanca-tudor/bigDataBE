package com.bigdata.app.service;

import com.bigdata.app.entity.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDataBatchProcessor {

    @Autowired
    private WeatherDataService weatherDataService;

    @Scheduled(fixedRate = 15000) // Process every 15 seconds
    public void processBatch() {
        List<WeatherData> batch = weatherDataService.findAll();
        if (!batch.isEmpty()) {
            batch.forEach(data -> {
                // Process the data here
                System.out.println("Processing Weather Data for city: Cluj-Napoca");
                // Example: Save to another service, perform analytics, etc.
            });

            // Optionally clear or mark the data as processed
            weatherDataService.deleteAll(batch); // If you want to delete after processing
            System.out.println("Batch processing complete.");
        }
    }
}

