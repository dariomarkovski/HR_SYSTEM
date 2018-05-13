package com.soa.hrSystem.zuul.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {
    static final long EXPIRATION_TIME = 864000000;
    static final String SECRET = "ThisIsASecret";
    static final String TOKEN_PREFIX = "BEARER ";
    static final String HEADER_STRING = "Authorization";

    static Authentication getAuthentication(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader(HEADER_STRING);
        if(token != null){
            String username = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            return username != null ? new UsernamePasswordAuthenticationToken(username, null, emptyList()) : null;
        }
        return null;
    }
}
