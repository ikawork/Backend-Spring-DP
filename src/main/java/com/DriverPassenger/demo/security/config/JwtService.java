package com.DriverPassenger.demo.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "PG4b6Lp9yuq+FWZf6gmNo6Pd8EB4kAvQgL++JRSidpMWjNZqWkSWXTyAmekDEWJeA2u51atyty6FVVlw6d8C87juVp+LQUdnyclVNWIu0PPs+cdSxzfl/FgL5DfzPZMt65WMxS9pCgSZem26bxgJM8V+MLIrIaZBw6qKdwVkYOArURE7UIzkeBLZhva7un90HbCPei9TMutwIx/UNkKZI4id5V5A4yAMI0AZmnol5AjOQRPbSR9INnnvUl3ZcRehzyFVrPNFsarRZZkaZ31fjBcGBYs0nodSApaW3kuiq2dpO2+VT3joyOSYw5d4+fflMcIAixUunG5Nw4SSaRAQk7ln9uVrTIv7uzGYh4dcyYI=\n";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractId(String token) {
        return extractAllClaim(token).get("userId").toString();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaim(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails
    ) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaim(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
