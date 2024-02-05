package com.fisa.fridge.global.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PasswordIncorrectException.class)
    public ExceptionResponse passwordException(PasswordIncorrectException e) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse notFoundException(NotFoundException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse validationNotNullException (MethodArgumentNotValidException e) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), e.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ExceptionResponse invalidRequestValueException(HttpMessageConversionException e) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "JSON형식이 잘못되었습니다.");
    }


}