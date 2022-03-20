package com.elad.CouponSystemV2Spring.exeptions;

public class CouponSystemException extends Exception {
    public CouponSystemException(ErrMsg errMsg){
        super(errMsg.getDescription());
    }

    public CouponSystemException(String msg){
        super(msg);
    }
}