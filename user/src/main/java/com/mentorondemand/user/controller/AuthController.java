package com.mentorondemand.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.user.config.JwtResponse;
import com.mentorondemand.user.config.JwtUtils;
import com.mentorondemand.user.core.ProgramException;
import com.mentorondemand.user.domain.User;
import com.mentorondemand.user.dto.UserDTO;
import com.mentorondemand.user.dto.UserJWTDTO;
import com.mentorondemand.user.mapper.UserMapper;
import com.mentorondemand.user.repository.RoleRepository;
import com.mentorondemand.user.repository.UserRepository;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserMapper roleMapper;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<JwtResponse> authenticateUser(@RequestBody UserDTO loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();	
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
//		UserJWTDTO userres= new UserJWTDTO();
//		userres.setUserName(userDetails.getUsername());
//		userres.setUserRoles(roles);
//		return ResponseEntity.ok(userres);
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getUsername(), 
												 roles));

	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO loginRequest) {
		if (userRepository.existsByUserName(loginRequest.getUserName())) {
			throw new ProgramException("Error: Username is already taken!");
		}
		User user = new User();
		user.setUserName(loginRequest.getUserName());
		user.setPassword(encoder.encode(loginRequest.getPassword()));
		user.setFirstName(loginRequest.getFirstName());
		user.setLastName(loginRequest.getLastName());
		user.setUserRoles(roleMapper.userRoleDtoToUserRoles(loginRequest.getUserRoles()));

		userRepository.save(user);

		return ResponseEntity.ok("User registered successfully!");
	}
	
	@PostMapping("/validatetoken")
	public ResponseEntity<Boolean> validateToken(@RequestBody String token){
		Boolean isValid = jwtUtils.validateJwtToken(token);
		return ResponseEntity.ok(isValid);
	}
}

