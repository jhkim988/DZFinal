package com.douzone.dzfinal.filter;

import com.douzone.dzfinal.entity.TokenPayload;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.openssl.PEMParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
import java.security.interfaces.RSAPublicKey;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Value("${publickey}")
    private String publicKey;

    @Autowired
    private ObjectMapper mapper;

        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
            if (request.getHeader("Authorization") != null) {
                String token = request.getHeader("Authorization").substring(7);
                String jwtPayload = new String(Base64.getDecoder().decode(token.split("\\.")[1]));
                TokenPayload tokenPayloadDTO = mapper.readValue(jwtPayload, TokenPayload.class);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                                tokenPayloadDTO
                                , null
                                , tokenPayloadDTO.getAuthorities()
                                    .stream()
                                    .map(str -> (GrantedAuthority) () -> str)
                                    .collect(Collectors.toList()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);
        }
}
