package com.pharmacy.PharmacyApi.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.pharmacy.PharmacyApi.user.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String GenerateToken(User user){
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("PharmacyApi").withSubject(user.getUsername()).withClaim("id", user.getId()).withExpiresAt(ExpirationDate()).sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token", exception);
        }
    }

    private Instant ExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
