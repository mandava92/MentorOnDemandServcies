package com.mentorondemand.user.dto;

import java.util.List;

import com.mentorondemand.user.validator.UserValidation;

@UserValidation
public class UserJWTDTO {


	private String userName;
	private List<String> userRoles;

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "UserJWTDTO [userName=" + userName + ", userRoles=" + userRoles + "]";
	}

	
	
	

}
