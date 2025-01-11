package com.bigdata.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamValues {
    private Double temperatureMin;

    private Double temperatureMax;

    private Double windSpeedMin;

    private Double windSpeedMax;

    private Double rainProbabilityMin;

    private Double rainProbabilityMax;
}
