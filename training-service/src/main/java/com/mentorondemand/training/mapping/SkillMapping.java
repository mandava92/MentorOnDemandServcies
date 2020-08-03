package com.mentorondemand.training.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.training.domain.Skills;
import com.mentorondemand.training.dto.SkillDTO;


@Mapper(componentModel = "spring", uses = {})
public interface SkillMapping {
	
	SkillDTO skillToSkillDto(Skills skill);
	List<SkillDTO> skillToSkillDto(List<Skills> skill);
	Skills skillDtoToSkill(SkillDTO skillDto);

}
