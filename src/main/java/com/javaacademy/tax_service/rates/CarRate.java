package com.javaacademy.tax_service.rates;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum CarRate {
    LIGHT_CAR(BigDecimal.valueOf(100));

    private final BigDecimal rate;
}
