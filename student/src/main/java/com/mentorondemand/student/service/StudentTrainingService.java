package com.mentorondemand.student.service;

import java.util.List;

import com.mentorondemand.student.dto.StudentTrainingDTO;

public interface StudentTrainingService {
	
	public StudentTrainingDTO createStudentTraining(StudentTrainingDTO trainingDTO);
	public StudentTrainingDTO updateStudentTraining(StudentTrainingDTO trainingDTO);
	public StudentTrainingDTO getStudentTraining(Integer trainingId);
	public List<StudentTrainingDTO> getProposedTrainings(String courseApprovalStatus, Integer mentorTrainingId);
	public List<StudentTrainingDTO> getStudentTrainings(String status);

}
