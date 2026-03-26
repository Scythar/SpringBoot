package com.self.SpringJDBCdemo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    // 🔐 Must be at least 256 bits (32 chars) for HS256
    private static final String SECRET =
            "nZr7P4lv+Y3rW7DH8sq8J8pQHXRuubIG9JpncCEgh9U=";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
    }

    /* ---------------------------------------
       Generate Token
       --------------------------------------- */
    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)  // ✅ roles embedded
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /* ---------------------------------------
       Extract Username
       --------------------------------------- */
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    /* ---------------------------------------
       Validate Token
       --------------------------------------- */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);  // throws if expired ✅
            return true;
        } catch (JwtException e) {
            // covers:
            // ExpiredJwtException      → token expired
            // MalformedJwtException    → token tampered
            // SignatureException       → wrong signature
            // UnsupportedJwtException  → wrong token type
            return false;
        }
    }

    /* ---------------------------------------
       Expiration check
       --------------------------------------- */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    /* ---------------------------------------
       Parse Claims
       --------------------------------------- */
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // extract roles from token
    public List<String> extractRoles(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())  // new API ✅
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.get("roles", List.class);  // roles stored as claim ✅
    }
}
