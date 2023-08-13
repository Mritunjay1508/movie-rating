package com.movieratingapp.application.exception;

public class PincodeException extends RuntimeException {

    public PincodeException(String message) {
        super(message);
    }

    public PincodeException(String message, Throwable cause) {
        super(message, cause);
    }
}