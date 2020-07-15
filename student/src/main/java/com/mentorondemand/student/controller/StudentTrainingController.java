package com.mentorondemand.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.student.dto.StudentTrainingDTO;
import com.mentorondemand.student.service.StudentTrainingService;

@RestController
@RequestMapping(value = "/api/v1/studenttraining")
public class StudentTrainingController {

	@Autowired
	private StudentTrainingService studentTrainingService;

	@PostMapping
	public ResponseEntity<StudentTrainingDTO> createTraining(@RequestBody StudentTrainingDTO studentTraining) {
		studentTrainingService.createStudentTraining(studentTraining);
		return null;
	}

	@PutMapping
	public ResponseEntity<StudentTrainingDTO> updateTraining(@RequestBody StudentTrainingDTO studentTraining) {
		studentTrainingService.createStudentTraining(studentTraining);
		return null;
	}

	@GetMapping
	public ResponseEntity<StudentTrainingDTO> getTrainings() {
		studentTrainingService.getStudentTrainings();
		return null;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudentTrainingDTO> getTraining(@PathVariable Integer trainingId) {
		studentTrainingService.getStudentTraining(trainingId);
		return null;
	}

}
