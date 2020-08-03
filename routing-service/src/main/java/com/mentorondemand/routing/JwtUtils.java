package com.mentorondemand.routing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	private String jwtSecret = "secret";

	private int jwtExpirationMs= 100000;

	/*
	 * public String generateJwtToken(Authentication authentication) {
	 * 
	 * UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
	 * 
	 * return Jwts.builder() .setSubject((userPrincipal.getUsername()))
	 * .setIssuedAt(new Date()) .setExpiration(new Date((new Date()).getTime() +
	 * jwtExpirationMs)) .signWith(SignatureAlgorithm.HS512, jwtSecret) .compact();
	 * }
	 */
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
