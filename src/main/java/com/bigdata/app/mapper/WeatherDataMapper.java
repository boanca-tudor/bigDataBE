package com.bigdata.app.mapper;


import com.bigdata.app.entity.*;
import com.fasterxml.jackson.databind.JsonNode;

public class WeatherDataMapper {
    public static WeatherData mapJsonToObject(JsonNode node) {
        JsonNode mainDataNode = node.get("main");
        MainWeatherData mainWeatherData = mainDataNode != null ? MainWeatherData.builder()
                .temperature(getDoubleValueFromSubNode(mainDataNode, "temp"))
                .feelsLike(getDoubleValueFromSubNode(mainDataNode, "feels_like"))
                .tempMin(getDoubleValueFromSubNode(mainDataNode, "temp_min"))
                .tempMax(getDoubleValueFromSubNode(mainDataNode, "temp_max"))
                .pressure(getIntValueFromSubNode(mainDataNode, "pressure"))
                .humidity(getIntValueFromSubNode(mainDataNode, "humidity"))
                .build() : null;
        JsonNode windNode = node.get("wind");
        WindData windData = windNode != null ? WindData.builder()
                .speed(getDoubleValueFromSubNode(windNode, "speed"))
                .degrees(getIntValueFromSubNode(windNode, "deg"))
                .gust(getDoubleValueFromSubNode(windNode, "gust"))
                .build() : null;
        JsonNode rainNode = node.get("rain");
        RainData rainData = rainNode != null ? RainData.builder()
                .perHour(getDoubleValueFromSubNode(rainNode, "1h"))
                .build() : null;
        JsonNode cloudNode = node.get("clouds");
        CloudData cloudData = cloudNode != null ? CloudData.builder()
                .all(getIntValueFromSubNode(cloudNode, "all"))
                .build() : null;
        return WeatherData.builder()
                .mainWeatherData(mainWeatherData)
                .windData(windData)
                .rainData(rainData)
                .cloudData(cloudData)
                .build();
    }

    private static Integer getIntValueFromSubNode(JsonNode parentNode, String fieldKey) {
        JsonNode node = parentNode.get(fieldKey);
        return node != null ? node.asInt() : null;
    }

    private static Double getDoubleValueFromSubNode(JsonNode parentNode, String fieldKey) {
        JsonNode node = parentNode.get(fieldKey);
        return node != null ? node.asDouble() : null;
    }

    private static String getStringValueFromSubNode(JsonNode parentNode, String fieldKey) {
        JsonNode node = parentNode.get(fieldKey);
        return node != null ? node.asText() : null;
    }
}
