package az.edu.orient.service;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import az.edu.orient.model.AuthRequest;
import az.edu.orient.model.AuthResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthService {

  private static final String JWT_SECRET = "IamSecret";

  public AuthResponse authResponse(AuthRequest authRequest) {
    if("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
        String accessToken = Jwts.builder()
            .claim("username", authRequest.getUsername())
            .setExpiration(Date.from(Instant.now().plus(15, ChronoUnit.MINUTES)))
            .signWith(SignatureAlgorithm.HS512, JWT_SECRET.getBytes())
            .compact();

        return AuthResponse.builder()
            .accessToken(accessToken)
            .build();
    }

    throw new RuntimeException("Username or password is not correct");
  }
}
