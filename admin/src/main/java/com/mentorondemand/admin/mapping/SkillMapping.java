package com.mentorondemand.admin.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.admin.domain.Skills;
import com.mentorondemand.admin.dto.SkillDTO;


@Mapper(componentModel = "spring", uses = {})
public interface SkillMapping {
	
	SkillDTO skillToSkillDto(Skills skill);
	List<SkillDTO> skillToSkillDto(List<Skills> skill);
	Skills skillDtoToSkill(SkillDTO skillDto);

}
