package com.bigdata.app.dto.api.helper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rain {
    @JsonProperty("1h")
    protected double oneHour;
}

