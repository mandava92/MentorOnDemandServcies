package com.mentorondemand.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PutMapping
	public ResponseEntity<UserDTO> updateUser(@Validated @RequestBody UserDTO user){
		user = userService.updateUser(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping(value = "/{userName}")
	public void deleteUser(@PathVariable String userName){
		userService.deleteUser(userName);
	}
	
	@GetMapping(value = "/{userName}")
	public ResponseEntity<UserDTO> getUser(@PathVariable String userName){
		UserDTO user = userService.getUser(userName);
		return ResponseEntity.ok(user);
	}

}
