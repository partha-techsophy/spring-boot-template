package com.techsophy.demo.exception;

public class ErrorReadingEntityException extends Exception {

    private static final long serialVersionUID = 1L;

    public ErrorReadingEntityException(String message){
        super(message);
    }
}
