package com.anmi.anime.exception;

/**
 * Created by wangjue on 2017/9/14.
 */
public class OneException extends Exception{
    private String message;

    public OneException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " , " + message;
    }
}
