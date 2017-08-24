package com.anmi.anime.fpt.fpt5.jaxb.common;

/**
 * Created by wangjue on 2017/7/12.
 */
public class FPT5Exception extends RuntimeException{
    private String message;

    public FPT5Exception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " , " + message;
    }
}
