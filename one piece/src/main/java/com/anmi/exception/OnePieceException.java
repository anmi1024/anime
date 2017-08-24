package com.anmi.exception;

/**
 * Created by wangjue on 2017/7/19.
 */
public class OnePieceException extends RuntimeException{

    private String message;

    public OnePieceException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " , " + message;
    }
}
