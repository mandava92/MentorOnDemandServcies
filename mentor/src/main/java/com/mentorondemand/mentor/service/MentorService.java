package com.mentorondemand.mentor.service;

import java.util.List;

import com.mentorondemand.mentor.dto.MentorTrainingDTO;
import com.mentorondemand.mentor.dto.StudentTrainingDTO;

public interface MentorService {
	
	public MentorTrainingDTO createMentorTraining(MentorTrainingDTO training);
	public MentorTrainingDTO updateMentorTraining(MentorTrainingDTO training);
	public MentorTrainingDTO getMentorTraining(Integer id);
	public List<MentorTrainingDTO> getMentorTrainings(String status);
	public List<StudentTrainingDTO> getApprovalTraining();
}
