package com.mentorondemand.user.dto;

import com.mentorondemand.user.validator.UserValidation;

import lombok.Data;

@UserValidation
@Data
public class UserDTO {
	
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private String password;
	private Integer roleId;
	private String role;
}
