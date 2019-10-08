package com.pos.controller.advice;

import java.lang.reflect.InvocationTargetException;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ApplicationControllerAdvice {

	@ExceptionHandler({ HttpMessageNotReadableException.class})
    public void handleHttpMessageNotReadableException() {
        log.error("Http Status : 400 - Bad Request");
    }
	
	
	@ExceptionHandler({ IllegalAccessException.class, InvocationTargetException.class,IllegalStateException.class, Exception.class})
    public void handleException() {
        log.error("Http Status : 500 - Internal server error");
    }
}
