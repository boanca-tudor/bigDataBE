package com.bigdata.app.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class WindData {
    private Double speed;

    private Integer degrees;

    private Double gust;
}
