package com.elad.CouponSystemV3Spring.exeptions;

public class CouponSystemException extends Exception {
    public CouponSystemException(ErrMsg errMsg){
        super(errMsg.getDescription());
    }

    public CouponSystemException(String msg){
        super(msg);
    }
}