package com.projet.resto2.utils;
import io.jsonwebtoken.*;

import io.jsonwebtoken.io.Decoders;

import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import java.util.Map;
import java.util.function.Function;

@Component
public class JWTUtil {
    private static  final String SECRET_KEY = "5efaa8f4fff00cac6428e8e51386cb7d8385fadd19ee026fdce7717c453d9937933f761a9f2a0b28bebb5626a83789701e327be45ee88a13b363215876e49733"; // 256bits Hex
    public String extractUserName(String token) {
//        System.out.println(extractClaim(token,Claims::getSubject));
        return extractClaim(token,Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(
            UserDetails userDetails
    ) {
        //create a token without extraClaims
        return  generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {
        System.out.println("username+"+userDetails.getUsername());
//        System.out.println("username+"+userDetails());
        return  Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 24h + 1000mS
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact(); // generate and return the token
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        // validate if the token belongs to this user
        final String username = extractUserName(token);
        return  (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        Claims c = null;
        try  {
            c = Jwts
                    .parserBuilder()
                    .setSigningKey(getSignInKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch ( RuntimeException e) {
            System.out.println(e.getMessage());
        } catch ( Exception e2) {
            System.out.println(e2.getMessage());
        }

//        System.out.println(c);

        return c;
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}