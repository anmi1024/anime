package com.anmi.anime;

/**
 * Created by wangjue on 2017/7/4.
 */
public class StructException extends Exception {
    private String message;

    public StructException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " , " + message;
    }
}
