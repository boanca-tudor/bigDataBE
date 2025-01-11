package com.bigdata.app.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("parameter_values")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParameterValues {

    @PrimaryKey
    private String key = "singleton";

    @Column("temperature_min")
    private Double temperatureMin;

    @Column("temperature_max")
    private Double temperatureMax;

    @Column("wind_speed_min")
    private Double windSpeedMin;

    @Column("wind_speed_max")
    private Double windSpeedMax;

    @Column("rain_probability_min")
    private Double rainProbabilityMin;

    @Column("rain_probability_max")
    private Double rainProbabilityMax;
}
