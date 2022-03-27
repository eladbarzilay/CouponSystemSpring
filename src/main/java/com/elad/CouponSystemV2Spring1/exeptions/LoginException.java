package com.elad.CouponSystemV2Spring1.exeptions;


public class LoginException extends Exception {
    public LoginException(String msg) {
        super(msg);
    }
}