package com.bigdata.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Embedded;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WeatherData {
    @Id
    @PrimaryKey
    private Long id;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected MainWeatherData mainWeatherData;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected WindData windData;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected RainData rainData;

    @Embedded(onEmpty = Embedded.OnEmpty.USE_NULL)
    protected CloudData cloudData;

}
