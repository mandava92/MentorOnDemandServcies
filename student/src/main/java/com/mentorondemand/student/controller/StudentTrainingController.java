package com.mentorondemand.student.controller;

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

import com.mentorondemand.student.dto.StudentTrainingDTO;
import com.mentorondemand.student.mapper.StudentTrainingMapper;
import com.mentorondemand.student.service.StudentTrainingService;

@RestController
@RequestMapping(value = "/api/studenttraining")
public class StudentTrainingController {

	@Autowired
	private StudentTrainingService studentTrainingService;

	@PostMapping
	public ResponseEntity<StudentTrainingDTO> createTraining(@RequestBody StudentTrainingDTO studentTraining) {
		StudentTrainingDTO response = studentTrainingService.createStudentTraining(studentTraining);
		return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<StudentTrainingDTO> updateTraining(@RequestBody StudentTrainingDTO studentTraining) {
		StudentTrainingDTO response = studentTrainingService.createStudentTraining(studentTraining);
		return ResponseEntity.ok(response);
	}

	@GetMapping
	public ResponseEntity<List<StudentTrainingDTO>> getProposedTrainings(@RequestParam(name = "courseApprovalStatus") String courseApprovalStatus,
			@RequestParam(name = "mentorTrainingId", required = false) Integer mentorTrainingId) {
		List<StudentTrainingDTO> response = studentTrainingService.getProposedTrainings(courseApprovalStatus,mentorTrainingId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping
	public ResponseEntity<List<StudentTrainingDTO>> getTrainings(@RequestParam(name = "status") String status) {
		List<StudentTrainingDTO> response = studentTrainingService.getStudentTrainings(status);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentTrainingDTO> getTraining(@PathVariable Integer trainingId) {
		StudentTrainingDTO response = studentTrainingService.getStudentTraining(trainingId);
		return ResponseEntity.ok(response);
	}

}
