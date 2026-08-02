package com.login_system.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.util.List;
import java.util.stream.Collectors;

public class JWTCreator {

    public static final String HEADER_AUTHORIZATION = "Authorization";

    public static final String ROLE_AUTHORITIES = "authorities";

    public static String create(String prefix, String key, JWTObject jwtObject) {
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));

        String token = Jwts.builder()
                .subject(jwtObject.getSubject())
                .issuedAt(jwtObject.getIssuedAt())
                .expiration(jwtObject.getExpiration())
                .claim(ROLE_AUTHORITIES, checkRoles(jwtObject.getRoles()))
                .signWith(secretKey, Jwts.SIG.HS512)
                .compact();

        return prefix + " " + token;
    }
    public static JWTObject create(String token, String prefix, String key) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException {
        JWTObject object = new JWTObject();
        token = token.replace(prefix, "");

        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        object.setSubject(claims.getSubject());
        object.setExpiration(claims.getExpiration());
        object.setRoles((List) claims.get(ROLE_AUTHORITIES));

        return object;
    }
    private static List<String> checkRoles(List<String> roles) {
        return roles.stream()
                .map(s -> "ROLE_".concat(s.replaceAll("ROLE_", "")))
                .collect(Collectors.toList());
    }

}
