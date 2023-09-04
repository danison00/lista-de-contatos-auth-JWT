package com.dan.jwt.web.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.dan.jwt.web.dto.LoginDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    
    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto){
        

    }
}
