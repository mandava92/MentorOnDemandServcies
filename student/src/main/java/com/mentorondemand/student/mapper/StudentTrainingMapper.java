package com.mentorondemand.student.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.student.domain.StudentTraining;
import com.mentorondemand.student.dto.StudentTrainingDTO;


@Mapper(componentModel = "spring", uses = {})
public interface StudentTrainingMapper {
	
	StudentTrainingDTO studentTrainingToDto(StudentTraining studentTraining);
	StudentTraining dtoToStudentTraining(StudentTrainingDTO studentTrainingDTO);
	
	List<StudentTrainingDTO> trainingsToDtos(List<StudentTraining> tarinings);

}
