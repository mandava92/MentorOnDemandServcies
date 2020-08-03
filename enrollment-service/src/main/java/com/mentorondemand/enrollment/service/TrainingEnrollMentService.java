package com.mentorondemand.enrollment.service;

import java.util.List;

import com.mentorondemand.enrollment.dto.TrainingEnrollmentDTO;

public interface TrainingEnrollMentService {
	
	public TrainingEnrollmentDTO enrollStudent(TrainingEnrollmentDTO trainingDTO);
	public TrainingEnrollmentDTO updateStudentEnrollment(TrainingEnrollmentDTO trainingDTO);
	public TrainingEnrollmentDTO getStudentTraining(Integer trainingId);
	public List<TrainingEnrollmentDTO> getProposedTrainings(String courseApprovalStatus, Integer mentorTrainingId);
	public List<TrainingEnrollmentDTO> getStudentTrainings(String status);

}
