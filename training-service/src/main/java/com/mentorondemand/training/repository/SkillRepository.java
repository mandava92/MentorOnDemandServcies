package com.mentorondemand.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.training.domain.Skills;

@Repository
public interface SkillRepository extends JpaRepository<Skills, Long>{

	Skills findById(Integer skillId);

}
