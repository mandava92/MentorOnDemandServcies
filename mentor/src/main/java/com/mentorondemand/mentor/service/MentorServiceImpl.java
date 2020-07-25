package com.mentorondemand.mentor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mentorondemand.mentor.domain.MentorTraining;
import com.mentorondemand.mentor.dto.CourseIndexDTO;
import com.mentorondemand.mentor.dto.MentorTrainingDTO;
import com.mentorondemand.mentor.dto.StudentTrainingDTO;
import com.mentorondemand.mentor.dto.UserDTO;
import com.mentorondemand.mentor.feign.SearchFeign;
import com.mentorondemand.mentor.feign.StudentFeign;
import com.mentorondemand.mentor.feign.UserFeign;
import com.mentorondemand.mentor.mapper.MentorTraingMapper;
import com.mentorondemand.mentor.repository.MentorTrainingRepository;

@Component
public class MentorServiceImpl implements MentorService{
	
	private static final String SEARCH_SERVICE = "http://localhost:9090/courses";
	
	@Autowired
	private MentorTrainingRepository repository;
	
	@Autowired
	private MentorTraingMapper mapper;
	
	@Autowired
	private StudentFeign studentFeign;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private UserFeign userFeign;
	
	@Autowired
	private SearchFeign searchFeign;
	

	public MentorTrainingDTO createMentorTraining(MentorTrainingDTO trainingDto) {
		MentorTraining training = mapper.dtoToTraining(trainingDto);
		training = repository.save(training);
		trainingDto = mapper.trainigToDto(training);
		indexCourse(trainingDto);
		return trainingDto;
	}
	
	@Async
	private  void indexCourse(MentorTrainingDTO training)
	{	
		UserDTO user = userFeign.getUser(training.getUserName());
		CourseIndexDTO courseIndexDTO = new CourseIndexDTO();
		courseIndexDTO.setCouseId(training.getCourseId().toString());
		courseIndexDTO.setUserName(training.getUserName());
		courseIndexDTO.setMentorName(user.getFirstName() +" "+user.getLastName());
		courseIndexDTO.setMentorFee(training.getAmount());
		courseIndexDTO.setCourseRating(training.getRatings());
	   // restTemplate.postForObject( SEARCH_SERVICE, courseIndexDTO, ResponseEntity.class);
		searchFeign.updateCourseSearch(courseIndexDTO);
	 
	}

	public MentorTrainingDTO updateMentorTraining(MentorTrainingDTO trainingDto) {
		MentorTraining training = mapper.dtoToTraining(trainingDto);
		training = repository.save(training);
		trainingDto = mapper.trainigToDto(training);
		indexCourse(trainingDto);
		return trainingDto;
	}

	public MentorTrainingDTO getMentorTraining(Integer id) {
		MentorTraining training = repository.findById(id);
		return mapper.trainigToDto(training);
	}

	public List<MentorTrainingDTO> getMentorTrainings(String status) {
		List<MentorTraining> trainings = repository.findByCourseStatus(status);
		return null;
	}

	public List<StudentTrainingDTO> getApprovalTraining(Integer userId) {
		List<StudentTrainingDTO> trainings = studentFeign.getPendingApprovals("Proposed",userId);
		return trainings;
	}
	
}
