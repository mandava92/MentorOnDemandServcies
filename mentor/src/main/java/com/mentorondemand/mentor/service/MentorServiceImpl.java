package com.mentorondemand.mentor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mentorondemand.mentor.domain.MentorTraining;
import com.mentorondemand.mentor.dto.MentorTrainingDTO;
import com.mentorondemand.mentor.dto.StudentTrainingDTO;
import com.mentorondemand.mentor.feign.StudentFeign;
import com.mentorondemand.mentor.mapper.MentorTraingMapper;
import com.mentorondemand.mentor.repository.MentorTrainingRepository;

@Component
public class MentorServiceImpl implements MentorService{
	
	@Autowired
	private MentorTrainingRepository repository;
	
	@Autowired
	private MentorTraingMapper mapper;
	
	@Autowired
	private StudentFeign studentFeign;
	

	public MentorTrainingDTO createMentorTraining(MentorTrainingDTO trainingDto) {
		MentorTraining training = mapper.dtoToTraining(trainingDto);
		training = repository.save(training);
		System.out.println(training);
		return mapper.trainigToDto(training);
	}

	public MentorTrainingDTO updateMentorTraining(MentorTrainingDTO trainingDto) {
		MentorTraining training = mapper.dtoToTraining(trainingDto);
		training = repository.save(training);
		return mapper.trainigToDto(training);
	}

	public MentorTrainingDTO getMentorTraining(Integer id) {
		MentorTraining training = repository.findById(id);
		return mapper.trainigToDto(training);
	}

	public List<MentorTrainingDTO> getMentorTrainings(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentTrainingDTO> getApprovalTraining() {
		List<StudentTrainingDTO> trainings = studentFeign.getPendingApprovals("Proposed",8);
		// TODO Auto-generated method stub
		return trainings;
	}
	
	

}
