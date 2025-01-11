package com.bigdata.app.dto.api.helper;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class Main {
    protected double temp;

    @JsonProperty("feels_like")
    protected double feelsLike;

    @JsonProperty("temp_min")
    protected double tempMin;

    @JsonProperty("temp_max")
    protected double tempMax;

    protected int pressure;

    protected int humidity;

    @JsonProperty("sea_level")
    protected int seaLevel;

    @JsonProperty("grnd_level")
    protected int grndLevel;

}
