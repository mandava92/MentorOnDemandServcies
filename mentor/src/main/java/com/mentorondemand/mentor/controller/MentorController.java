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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.mentor.dto.MentorTrainingDTO;
import com.mentorondemand.mentor.dto.StudentTrainingDTO;
import com.mentorondemand.mentor.service.MentorService;

@RestController
@RequestMapping(value = "/api/mentor")
public class MentorController {
	
	@Autowired
	private MentorService mentorService;
	
	
	@PostMapping
	public ResponseEntity<MentorTrainingDTO> create(@RequestBody MentorTrainingDTO trainingDTO) {
		MentorTrainingDTO training = mentorService.createMentorTraining(trainingDTO);
		return ResponseEntity.ok(training);
	}

	@PutMapping
	public ResponseEntity<MentorTrainingDTO> update(@RequestBody MentorTrainingDTO trainingDTO) {
		MentorTrainingDTO training = mentorService.updateMentorTraining(trainingDTO);
		return ResponseEntity.ok(training);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MentorTrainingDTO> getTraining(@PathVariable Integer id){
		MentorTrainingDTO training = mentorService.getMentorTraining(id);
		return ResponseEntity.ok(training);
	}
	
	@GetMapping
	public ResponseEntity<List<MentorTrainingDTO>> getTrainings(@RequestParam(value = "status") String status){
		List<MentorTrainingDTO> training = mentorService.getMentorTrainings(status);
		return ResponseEntity.ok(training);
	}
	
	@GetMapping(value = "/approveStudentTraining")
	public ResponseEntity<List<StudentTrainingDTO>> getApprovalTraining() {
		List<StudentTrainingDTO> training = mentorService.getApprovalTraining();
		return ResponseEntity.ok(training);
	}
	
}
