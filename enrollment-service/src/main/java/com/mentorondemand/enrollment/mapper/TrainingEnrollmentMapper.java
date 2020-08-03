package com.mentorondemand.enrollment.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.enrollment.domain.TrainingEnrollment;
import com.mentorondemand.enrollment.dto.TrainingEnrollmentDTO;


@Mapper(componentModel = "spring", uses = {})
public interface TrainingEnrollmentMapper {
	
	TrainingEnrollmentDTO studentTrainingToDto(TrainingEnrollment studentTraining);
	TrainingEnrollment dtoToStudentTraining(TrainingEnrollmentDTO studentTrainingDTO);
	
	List<TrainingEnrollmentDTO> trainingsToDtos(List<TrainingEnrollment> tarinings);

}
