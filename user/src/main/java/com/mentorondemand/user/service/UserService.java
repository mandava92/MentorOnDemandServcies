package com.mentorondemand.user.service;

import com.mentorondemand.user.dto.UserDTO;

public interface UserService {

	public UserDTO createUser(UserDTO userDTO);
	public UserDTO updateUser(UserDTO userDTO);
	public void deleteUser(String id);
	public UserDTO getUser(String id);
	
}
