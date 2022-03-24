package com.elad.CouponSystemV3Spring.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrDto {
    private final String key = "Something went wrong, please try again!";
    private String message;
}