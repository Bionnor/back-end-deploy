package com.flora.backend.exceptions;

public class DataAccessException extends RuntimeException{
    public DataAccessException(String message) {
        super(message);
    }
}
