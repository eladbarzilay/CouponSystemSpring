package com.elad.CouponSystemV3Spring.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String key;
    private String value;
}