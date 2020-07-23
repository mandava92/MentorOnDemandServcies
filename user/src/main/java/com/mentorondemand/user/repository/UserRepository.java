package com.mentorondemand.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findById(Integer id);

	User findByUserName(String userName);

	boolean existsByUserName(String userName);

}
