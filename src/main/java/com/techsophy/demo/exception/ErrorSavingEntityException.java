package com.techsophy.demo.exception;

public class ErrorSavingEntityException extends Exception {

    private static final long serialVersionUID = 1L;

    public ErrorSavingEntityException(String message){
        super(message);
    }
}
