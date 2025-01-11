package com.bigdata.app.mapper;

import com.bigdata.app.dto.ParamValues;
import com.bigdata.app.entity.ParameterValues;

public class ParameterValuesMapper {

    public static ParameterValues fromDto(ParamValues dto) {
        ParameterValues parameterValues = new ParameterValues();

        parameterValues.setTemperatureMin(dto.getTemperatureMin());
        parameterValues.setTemperatureMax(dto.getTemperatureMax());

        parameterValues.setWindSpeedMin(dto.getWindSpeedMin());
        parameterValues.setWindSpeedMax(dto.getWindSpeedMax());

        parameterValues.setRainProbabilityMin(dto.getRainProbabilityMin());
        parameterValues.setRainProbabilityMax(dto.getRainProbabilityMax());

        return parameterValues;
    }
}
