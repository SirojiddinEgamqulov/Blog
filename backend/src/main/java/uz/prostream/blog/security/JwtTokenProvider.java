package uz.prostream.blog.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.prostream.blog.entity.User;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwtSecret}")
    private String secretKey;

    @Value("${app.jwtExpirationInMs}")
    private Long expiredTime;

    public String generateToken(User user) {
        Date durationTimeLife = new Date(new Date().getTime() + expiredTime);
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .claim("roles", user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(durationTimeLife)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }
}
