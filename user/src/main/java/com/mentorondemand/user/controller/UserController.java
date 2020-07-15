package com.mentorondemand.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.user.dto.UserDTO;
import com.mentorondemand.user.service.UserService;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@PostMapping
	public ResponseEntity<UserDTO> createUser(@Validated @RequestBody UserDTO user){
		userService.createUser(user);
		return null;
	}
	
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@Validated @RequestBody UserDTO user){
		userService.updateUser(user);
		return null;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Integer userId){
		userService.deleteUser(userId);
		return null;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer userId){
		userService.getUser(userId);
		return null;
	}

}
