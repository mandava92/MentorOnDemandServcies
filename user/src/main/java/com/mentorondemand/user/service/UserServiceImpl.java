package com.mentorondemand.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentorondemand.user.domain.User;
import com.mentorondemand.user.dto.UserDTO;
import com.mentorondemand.user.dto.UserRolesDTO;
import com.mentorondemand.user.mapper.UserMapper;
import com.mentorondemand.user.repository.UserRepository;
@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;

	public UserDTO createUser(UserDTO userDTO) {
		User user = userMapper.userDtoToUser(userDTO);
		user = userRepository.save(user);
		return userMapper.usetToUserDto(user);
	}

	private List<UserRolesDTO> saveOrUpdateUserRoles(List<UserRolesDTO> userRoles, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO updateUser(UserDTO userDTO) {
		User user = userMapper.userDtoToUser(userDTO);
		user = userRepository.save(user);
		return userMapper.usetToUserDto(user);
	}

	public void deleteUser(Integer id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
	}

	public UserDTO getUser(Integer id) {
		User user = userRepository.findById(id);
		System.out.println(user);
		return userMapper.usetToUserDto(user);
	}

	
}
