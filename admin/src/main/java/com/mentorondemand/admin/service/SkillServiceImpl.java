package com.mentorondemand.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.admin.domain.Skills;
import com.mentorondemand.admin.dto.SkillDTO;
import com.mentorondemand.admin.mapping.SkillMapping;
import com.mentorondemand.admin.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillRepository repository;
	
	@Autowired
	private SkillMapping mapper;
	
	public SkillDTO getSkill(Integer skillId) {
		Skills skill = repository.findById(skillId);
		return mapper.skillToSkillDto(skill);
	}

	public List<SkillDTO> getSkills() {
		List<Skills> skills = repository.findAll();
		return mapper.skillToSkillDto(skills);
	}
	
	

}
