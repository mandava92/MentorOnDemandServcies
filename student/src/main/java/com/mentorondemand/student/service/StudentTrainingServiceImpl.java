package com.mentorondemand.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.student.domain.StudentTraining;
import com.mentorondemand.student.dto.StudentTrainingDTO;
import com.mentorondemand.student.mapper.StudentTrainingMapper;
import com.mentorondemand.student.repository.StudentTrainingRepository;

@Service
public class StudentTrainingServiceImpl implements StudentTrainingService{
	
	@Autowired
	private StudentTrainingMapper mapper;
	
	@Autowired
	private StudentTrainingRepository repository;

	public StudentTrainingDTO createStudentTraining(StudentTrainingDTO trainingDTO) {
		StudentTraining training = mapper.dtoToStudentTraining(trainingDTO);
		training = repository.save(training);
		return mapper.studentTrainingToDto(training);
	}

	public StudentTrainingDTO updateStudentTraining(StudentTrainingDTO trainingDTO) {
		StudentTraining training = mapper.dtoToStudentTraining(trainingDTO);
		training = repository.save(training);
		return mapper.studentTrainingToDto(training);
	}

	public StudentTrainingDTO getStudentTraining(Integer trainingId) {
		StudentTraining training= repository.findById(trainingId);
		return mapper.studentTrainingToDto(training);
	}

	public List<StudentTrainingDTO> getProposedTrainings(String courseApprovalStatus, Integer mentorTrainingId) {
		List<StudentTraining> trainings = repository.findByCourseApprovalStatusAndMentorTrainingId(courseApprovalStatus,mentorTrainingId);
		return mapper.trainingsToDtos(trainings);
	}

	public List<StudentTrainingDTO> getStudentTrainings(String status) {
		//findByStatus(status);
		return null;
	}

}
