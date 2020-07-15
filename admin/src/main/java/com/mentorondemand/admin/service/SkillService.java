package com.mentorondemand.admin.service;

import java.util.List;

import com.mentorondemand.admin.dto.SkillDTO;

public interface SkillService {

	public SkillDTO getSkill(Integer skillId);
	public List<SkillDTO> getSkills();
}
