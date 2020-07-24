package com.mentorondemand.user.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	private String jwtSecret = "secret";

	private int jwtExpirationMs= 1000000000;

	public String generateJwtToken(Authentication authentication) {

		 UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

		Map<String, Object> claims = new HashMap();
		claims.put("roles", userPrincipal.getAuthorities());
		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		}

		return false;
	}
}
