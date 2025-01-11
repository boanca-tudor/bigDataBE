package com.bigdata.app.dto.api;

import com.bigdata.app.dto.api.helper.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class WeatherApiResponse {
    protected Coord coord;

    protected List<Weather> weather;

    protected String base;

    protected Main main;

    protected int visibility;

    protected Wind wind;

    protected Rain rain;

    protected Clouds clouds;

    protected long dt;

    protected Sys sys;

    protected int timezone;

    protected long id;

    protected String name;

    protected int cod;
}

