package com.mentorondemand.enrollment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mentorondemand.enrollment.domain.TrainingEnrollment;
import com.mentorondemand.enrollment.dto.CourseIndexDTO;
import com.mentorondemand.enrollment.dto.TrainingEnrollmentDTO;
import com.mentorondemand.enrollment.feign.SearchFeign;
import com.mentorondemand.enrollment.mapper.TrainingEnrollmentMapper;
import com.mentorondemand.enrollment.repository.TrainingEnrollMentServiceRepository;

@Service
public class TrainingEnrollMentServiceImpl implements TrainingEnrollMentService{
	
	@Autowired
	private TrainingEnrollmentMapper mapper;
	
	@Autowired
	private TrainingEnrollMentServiceRepository repository;
	
	@Autowired
	private SearchFeign searchFeign;
	
//	@Autowired
//	private MentorFeign mentorFeign;

	public TrainingEnrollmentDTO enrollStudent(TrainingEnrollmentDTO trainingDTO) {
		TrainingEnrollment training = mapper.dtoToStudentTraining(trainingDTO);
		training.setCourseApprovalStatus(trainingDTO.getCourseApprovalStatus());
		training = repository.save(training);
		trainingDTO= mapper.studentTrainingToDto(training);
		trainingDTO.setCourseApprovalStatus(training.getCourseApprovalStatus());
		trainingDTO.setId(training.getId());
		indexCourse(trainingDTO);
		return trainingDTO;
	}
	
	@Async
	private  void indexCourse(TrainingEnrollmentDTO trainee)
	{	
		CourseIndexDTO courseIndexDTO = new CourseIndexDTO();
		courseIndexDTO.setCourseId(trainee.getCourseId().toString());
		courseIndexDTO.setTrainee(trainee);
		searchFeign.updateCourseSearch(courseIndexDTO);
	 
	}

	public TrainingEnrollmentDTO updateStudentEnrollment(TrainingEnrollmentDTO trainingDTO) {
		TrainingEnrollment training = mapper.dtoToStudentTraining(trainingDTO);
		training = repository.save(training);
		trainingDTO= mapper.studentTrainingToDto(training);
		indexCourse(trainingDTO);
		return trainingDTO;
	}

	public TrainingEnrollmentDTO getStudentTraining(Integer trainingId) {
		TrainingEnrollment training= repository.findById(trainingId);
		return mapper.studentTrainingToDto(training);
	}

	public List<TrainingEnrollmentDTO> getProposedTrainings(String courseApprovalStatus, Integer mentorTrainingId) {
		List<TrainingEnrollment> trainings = repository.findByCourseApprovalStatusAndCourseId(courseApprovalStatus,mentorTrainingId);
		return mapper.trainingsToDtos(trainings);
	}

	public List<TrainingEnrollmentDTO> getStudentTrainings(String status) {
		//findByStatus(status);
		return null;
	}

}
