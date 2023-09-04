package com.dan.jwt.infra;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionsHandler extends Exception {
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validField(MethodArgumentNotValidException e){

        var errors = new HashMap<String, String>();

        BindingResult binding = e.getBindingResult();

        binding.getFieldErrors().forEach(
            error -> errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
        
    }



}
