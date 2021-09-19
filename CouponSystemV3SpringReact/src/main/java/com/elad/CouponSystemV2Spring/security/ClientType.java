package com.elad.CouponSystemV2Spring.security;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ClientType {
    ADMINISTRATOR,
//    (1, "Administrator"),
    COMPANY,
//    (2, "Company"),
    CUSTOMER
    
//    (3, "Customer");

//    private final String name;
//    private final int index;
//
//    ClientType(int index, String name) {
//        this.name = name;
//        this.index = index;
//    }
}