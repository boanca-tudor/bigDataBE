package com.bigdata.app.entity;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MainWeatherData {
    protected Double temperature;

    protected Double feelsLike;

    protected Double tempMin;

    protected Double tempMax;

    protected Integer pressure;

    protected Integer humidity;
}
