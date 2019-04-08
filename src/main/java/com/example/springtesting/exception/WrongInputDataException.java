package com.example.springtesting.exception;

public class WrongInputDataException extends Exception {
    public WrongInputDataException(String message) {
        super(message);
    }
}
