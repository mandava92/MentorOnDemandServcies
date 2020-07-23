package com.mentorondemand.user.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mentorondemand.user.core.ProgramException;
import com.mentorondemand.user.domain.Role;
import com.mentorondemand.user.domain.User;
import com.mentorondemand.user.repository.RoleRepository;
import com.mentorondemand.user.repository.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user != null) {
			List<Integer> roleIds = user.getUserRoles().stream().map(e->e.getRoleId()).collect(Collectors.toList());
			List<Role> roles = roleRepository.findByIdIn(roleIds);
			
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),roles.stream()
					.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
					.collect(Collectors.toList()));
		}
		throw new ProgramException("User Not Found with username: " + username);
	}

}
