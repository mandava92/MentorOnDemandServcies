package com.mentorondemand.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.mentorondemand.common.dto.CourseIndexDTO;
import com.mentorondemand.common.dto.StudentDTO;
import com.mentorondemand.student.domain.StudentTraining;
import com.mentorondemand.student.dto.MentorTrainingDTO;
import com.mentorondemand.student.dto.StudentTrainingDTO;
import com.mentorondemand.student.feign.MentorFeign;
import com.mentorondemand.student.feign.SearchFeign;
import com.mentorondemand.student.feign.UserFeign;
import com.mentorondemand.student.mapper.StudentTrainingMapper;
import com.mentorondemand.student.repository.StudentTrainingRepository;

@Service
public class StudentTrainingServiceImpl implements StudentTrainingService{
	
	@Autowired
	private StudentTrainingMapper mapper;
	
	@Autowired
	private StudentTrainingRepository repository;
	
	@Autowired
	private SearchFeign searchFeign;
	
	@Autowired
	private MentorFeign mentorFeign;

	public StudentTrainingDTO createStudentTraining(StudentTrainingDTO trainingDTO) {
		StudentTraining training = mapper.dtoToStudentTraining(trainingDTO);
		training = repository.save(training);
		trainingDTO= mapper.studentTrainingToDto(training);
		indexCourse(trainingDTO);
		return trainingDTO;
	}
	
	@Async
	private  void indexCourse(StudentTrainingDTO training)
	{	
		MentorTrainingDTO mentorTraining = mentorFeign.getMentorTrainingDetails(training.getMentorTrainingId());
		StudentDTO student = new StudentDTO();
//		student.setMentorTrainingId(training);
		CourseIndexDTO courseIndexDTO = new CourseIndexDTO();
//		courseIndexDTO.setTrainees(list);
		courseIndexDTO.setCourseId(mentorTraining.getCourseId().toString());
//		courseIndexDTO.setUserName(training.getUserId().toString());
////		courseIndexDTO.setMentorName(mentorName);
//	    restTemplate.postForObject( SEARCH_SERVICE, courseIndexDTO, ResponseEntity.class);
//		searchFeign.updateCourseSearch(courseIndexDTO);
	 
	}

	public StudentTrainingDTO updateStudentTraining(StudentTrainingDTO trainingDTO) {
		StudentTraining training = mapper.dtoToStudentTraining(trainingDTO);
		training = repository.save(training);
		trainingDTO= mapper.studentTrainingToDto(training);
		indexCourse(trainingDTO);
		return trainingDTO;
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
