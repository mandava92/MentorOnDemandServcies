package com.mentorondemand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.user.domain.UserRoles;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{
	
	

}
