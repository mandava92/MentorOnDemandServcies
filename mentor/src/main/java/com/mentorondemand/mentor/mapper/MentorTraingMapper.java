package com.mentorondemand.mentor.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.mentor.domain.MentorTraining;
import com.mentorondemand.mentor.dto.MentorTrainingDTO;


@Mapper(componentModel = "spring", uses = {})
public interface MentorTraingMapper {
	
	MentorTrainingDTO trainigToDto(MentorTraining training);
	MentorTraining dtoToTraining(MentorTrainingDTO dto);
	
	List<MentorTrainingDTO> trainingsToDtos(List<MentorTraining> trainings);

}
