package com.login_system.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.SignatureException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private SecurityConfig securityConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token =  request.getHeader(JWTCreator.HEADER_AUTHORIZATION);

        try {
            if (token != null && !token.isEmpty()) {
                JWTObject tokenObject = JWTCreator.create(token, securityConfig.PREFIX, securityConfig.KEY);
                List<SimpleGrantedAuthority> authorities = authorities(tokenObject.getRoles());
                UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(tokenObject.getSubject(), null, authorities);
                SecurityContextHolder.getContext().setAuthentication(userToken);
            } else {
                SecurityContextHolder.clearContext();
            }
            filterChain.doFilter(request, response);

        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }

    private List<SimpleGrantedAuthority> authorities(List<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

}
