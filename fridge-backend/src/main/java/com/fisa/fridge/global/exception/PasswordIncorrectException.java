package com.fisa.fridge.global.exception;


public class PasswordIncorrectException extends RuntimeException{

    public PasswordIncorrectException(String message) {
        super(message);
    }
}