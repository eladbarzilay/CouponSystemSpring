package com.elad.CouponSystemV2Spring1.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String key;
    private String value;
}