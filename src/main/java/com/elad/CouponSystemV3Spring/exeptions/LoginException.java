package com.elad.CouponSystemV3Spring.exeptions;


public class LoginException extends Exception {
    public LoginException(String msg) {
        super(msg);
    }
}