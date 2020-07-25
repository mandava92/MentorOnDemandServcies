package com.mentorondemand.admin.service;

import java.util.List;

import com.mentorondemand.admin.domain.Skills;
import com.mentorondemand.admin.dto.SkillDTO;

public interface SkillService {

	public SkillDTO getSkill(Integer skillId);
	public List<SkillDTO> getSkills();
	public SkillDTO createSkill(SkillDTO skill);
	public SkillDTO updateSkill(SkillDTO skill);
}
