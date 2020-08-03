package com.mentorondemand.training.service;

import java.util.List;

import com.mentorondemand.training.domain.Skills;
import com.mentorondemand.training.dto.SkillDTO;

public interface SkillService {

	public SkillDTO getSkill(Integer skillId);
	public List<SkillDTO> getSkills();
	public SkillDTO createSkill(SkillDTO skill);
	public SkillDTO updateSkill(SkillDTO skill);
}
