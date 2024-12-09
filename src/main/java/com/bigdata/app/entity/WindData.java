package com.bigdata.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WindData {
    private Double speed;

    private Integer degrees;

    private Double gust;
}
