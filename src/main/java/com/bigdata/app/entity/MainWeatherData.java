package com.bigdata.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MainWeatherData {
    protected Double temperature;

    protected Double feelsLike;

    protected Double tempMin;

    protected Double tempMax;

    protected Integer pressure;

    protected Integer humidity;
}
