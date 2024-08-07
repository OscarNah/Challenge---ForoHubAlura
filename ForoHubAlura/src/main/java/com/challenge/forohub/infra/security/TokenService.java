package com.challenge.forohub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.challenge.forohub.model.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion(5))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException();
        }
        DecodedJWT decodedJWT = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("forohub")
                    .build();
            decodedJWT = verifier.verify(token);
        } catch (JWTVerificationException exception) {
            System.out.println(exception.toString());
        }
        if (decodedJWT == null || decodedJWT.getSubject() == null) {
            throw new RuntimeException("Invalid Verifier");
        }
        return decodedJWT.getSubject();
    }

    private Instant generarFechaExpiracion(int horas) {
        return LocalDateTime.now().plusHours(horas).toInstant(ZoneOffset.of("-05:00"));
    }
}
