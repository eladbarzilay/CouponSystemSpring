package com.elad.CouponSystemV2Spring.exeptions;


public class LoginException extends Exception {
    public LoginException(String msg) {
        super(msg);
    }
}