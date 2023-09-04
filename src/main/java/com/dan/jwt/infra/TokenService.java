package com.dan.jwt.infra;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.dan.jwt.domain.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    String secret;

    public String genereteToken(User user) {

        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("api-contatos-app")
                    .withSubject(user.getUsername())
                    .withExpiresAt(LocalDateTime.now().plusMinutes(3).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);

            return token;

        } catch (JWTCreationException e) {
            throw new RuntimeException("erro ao criar token", e);
        }
    }

    public String validateToken(String token){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("api-contatos-app")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return "";
        }

    }

}
