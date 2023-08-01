package com.helloworldgroup.helloworld.errorhandle;

import models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(webRequest.getContextPath(),exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
