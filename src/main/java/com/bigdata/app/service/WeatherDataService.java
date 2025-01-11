package com.bigdata.app.service;

import com.bigdata.app.entity.WeatherData;
import com.bigdata.app.repo.WeatherDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WeatherDataService {
    @Autowired
    protected WeatherDataRepo weatherDataRepo;

    public List<WeatherData> findAll() {
        return weatherDataRepo.findAll();
    }

    public Optional<WeatherData> getWeatherDataById(UUID id) {
        return weatherDataRepo.findById(id);
    }

    public WeatherData createWeatherData(WeatherData WeatherData) {
        return weatherDataRepo.save(WeatherData);
    }

    public void deleteWeatherData(UUID id) {
        weatherDataRepo.deleteById(id);
    }

    public void deleteAll(List<WeatherData> weatherData) {
        weatherDataRepo.deleteAll(weatherData);
    }
}
