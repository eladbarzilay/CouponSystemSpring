package com.elad.CouponSystemV2Spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.elad.CouponSystemV2Spring.security.Information;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyConfiguration {

    @Bean
    public Map<String, Information> map(){
        return new HashMap<>();
    }
}