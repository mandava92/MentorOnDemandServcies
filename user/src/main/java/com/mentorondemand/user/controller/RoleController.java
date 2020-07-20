package com.mentorondemand.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.user.dto.RoleDTO;

@RestController
@RequestMapping(value = "/api/roles")
public class RoleController {

	@GetMapping
	public ResponseEntity<List<RoleDTO>> getRoles() {
		return null;
	}
}
