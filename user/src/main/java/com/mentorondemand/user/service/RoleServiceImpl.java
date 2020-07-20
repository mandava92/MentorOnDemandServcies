package com.mentorondemand.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mentorondemand.user.domain.Role;
import com.mentorondemand.user.dto.RoleDTO;
import com.mentorondemand.user.mapper.RoleMapper;
import com.mentorondemand.user.repository.RoleRepository;

public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMapper roleMapper;

	public List<RoleDTO> getRoles() {
		List<RoleDTO> roleDtos = new ArrayList<RoleDTO>();
		List<Role> roles = roleRepository.findAll();
		if(roles != null)
			roleDtos =  roleMapper.roleToRoleDTOs(roles);
		return roleDtos;
	}

}
