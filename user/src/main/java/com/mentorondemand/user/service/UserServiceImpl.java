package com.mentorondemand.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.mentorondemand.user.core.ProgramException;
import com.mentorondemand.user.domain.User;
import com.mentorondemand.user.dto.UserDTO;
import com.mentorondemand.user.mapper.UserMapper;
import com.mentorondemand.user.repository.UserRepository;
@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	public UserDTO createUser(UserDTO userDTO) {
		User user = userMapper.userDtoToUser(userDTO);
		user = userRepository.save(user);
		return userMapper.usetToUserDto(user);
	}

	public UserDTO updateUser(UserDTO userDTO) {
		User user = userMapper.userDtoToUser(userDTO);
		user = userRepository.save(user);
		return userMapper.usetToUserDto(user);
	}

	public void deleteUser(String userName) {
		User user = userRepository.findByUserName(userName);
		userRepository.delete(user);
	}

	public UserDTO getUser(String userName) {
		User user = userRepository.findByUserName(userName);
		System.out.println(user);
		return userMapper.usetToUserDto(user);
	}

	
}
