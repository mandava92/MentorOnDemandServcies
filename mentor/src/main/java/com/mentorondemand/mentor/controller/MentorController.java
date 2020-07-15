package com.mentorondemand.mentor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.mentor.dto.MentorTrainingDTO;
import com.mentorondemand.mentor.dto.StudentTrainingDTO;
import com.mentorondemand.mentor.service.MentorService;

@RestController
@RequestMapping(value = "/api/mentorTraining")
public class MentorController {
	
	@Autowired
	private MentorService mentorService;
	
	
	@PostMapping(value = "/")
	public ResponseEntity<MentorTrainingDTO> create(@RequestBody MentorTrainingDTO trainingDTO) {
		mentorService.createMentorTraining(trainingDTO);
		return null;
	}

	@PutMapping(value = "/")
	public ResponseEntity<MentorTrainingDTO> update(@RequestBody MentorTrainingDTO trainingDTO) {
		mentorService.updateMentorTraining(trainingDTO);
		return null;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MentorTrainingDTO> getTraining(@PathVariable Integer id){
		mentorService.getMentorTraining(id);
		return null;
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<MentorTrainingDTO> getTrainings(){
		mentorService.getMentorTrainings();
		return null;
	}
	
	@PutMapping(value = "/approveStudentTraining")
	public ResponseEntity<List<StudentTrainingDTO>> getApprovalTraining(@RequestBody StudentTrainingDTO trainingDTO) {
		mentorService.getApprovalTraining();
		return null;
	}

}
