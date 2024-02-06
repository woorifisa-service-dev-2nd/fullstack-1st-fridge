package com.fisa.fridge.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ExceptionResponse {
    private int status;
    private String message;
}