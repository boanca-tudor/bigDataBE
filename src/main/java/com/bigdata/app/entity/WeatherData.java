package com.bigdata.app.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Embedded;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("weather_data")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WeatherData {
    @Id
    @PrimaryKey
    private UUID id;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected MainWeatherData mainWeatherData;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected WindData windData;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected RainData rainData;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected CloudData cloudData;

    protected String timestamp;
}
