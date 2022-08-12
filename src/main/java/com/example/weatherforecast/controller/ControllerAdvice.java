package com.example.weatherforecast.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public String onNullPointerException(){
        return "Check entered value!";
    }
}
