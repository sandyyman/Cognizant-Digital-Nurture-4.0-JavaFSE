package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET)
    public String authenticate(HttpServletRequest request) {
        LOGGER.info("START");

        // Get Authorization header and decode it
        String authHeader = request.getHeader("Authorization");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String encoded = authHeader.substring("Basic ".length());
        byte[] decoded = Base64.getDecoder().decode(encoded);
        String[] parts = new String(decoded).split(":");
        String username = parts[0];

        LOGGER.debug("Decoded username: {}", username);

        return generateJwt(username);
    }

    private String generateJwt(String username) {
        String secret = "my-super-secret-key-for-jwt-signing-12345678";
        Key key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 20 * 60 * 1000)) // 20 mins
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
