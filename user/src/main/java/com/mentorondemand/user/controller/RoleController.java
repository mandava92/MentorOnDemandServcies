package com.mentorondemand.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.user.dto.RoleDTO;
import com.mentorondemand.user.service.RoleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<RoleDTO>> getRoles() {
		return ResponseEntity.ok(roleService.getRoles());
	}
}
