package com.dan.jwt.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.dan.jwt.domain.Roles;
import com.dan.jwt.domain.User;
import com.dan.jwt.infra.TokenService;
import com.dan.jwt.repository.UserRepository;
import com.dan.jwt.service.UserService;
import com.dan.jwt.web.dto.LoginDto;
import com.dan.jwt.web.dto.ResgisterDto;

import ch.qos.logback.core.subst.Token;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDto loginDto){
        
        var usernamePassword = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.genereteToken((User)auth.getPrincipal());

        return ResponseEntity.ok("token: "+token);

    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ResgisterDto registerDto) {

        if (this.userService.loadUserByUsername(registerDto.username()) != null) {
            return ResponseEntity.badRequest().body("usuario já existe");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDto.password());
        var newUser = new User(registerDto.username(), encryptedPassword, Roles.USER);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
