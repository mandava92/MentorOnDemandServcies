package com.mentorondemand.enrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.enrollment.dto.TrainingEnrollmentDTO;
import com.mentorondemand.enrollment.service.TrainingEnrollMentService;

@RestController
@RequestMapping(value = "/api/enroll")
public class TrainingEnrollmentController {

	@Autowired
	private TrainingEnrollMentService enrollmentService;

	@PostMapping
	public ResponseEntity<TrainingEnrollmentDTO> enrollStudent(@RequestBody TrainingEnrollmentDTO studentTraining) {
		TrainingEnrollmentDTO response = enrollmentService.enrollStudent(studentTraining);
		return ResponseEntity.ok(response);
	}

	@PutMapping
	public ResponseEntity<TrainingEnrollmentDTO> changeEnrollMentStatus(@RequestBody TrainingEnrollmentDTO studentTraining) {
		TrainingEnrollmentDTO response = enrollmentService.enrollStudent(studentTraining);
		return ResponseEntity.ok(response);
	}

//	@GetMapping
//	public ResponseEntity<List<TrainingEnrollmentDTO>> getProposedTrainings(@RequestParam(name = "courseApprovalStatus") String courseApprovalStatus,
//			@RequestParam(name = "mentorTrainingId", required = false) Integer mentorTrainingId) {
//		List<TrainingEnrollmentDTO> response = enrollmentService.getProposedTrainings(courseApprovalStatus,mentorTrainingId);
//		return ResponseEntity.ok(response);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<TrainingEnrollmentDTO>> getTrainings(@RequestParam(name = "status") String status) {
//		List<TrainingEnrollmentDTO> response = enrollmentService.getStudentTrainings(status);
//		return ResponseEntity.ok(response);
//	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<TrainingEnrollmentDTO> getTraining(@PathVariable Integer trainingId) {
//		TrainingEnrollmentDTO response = enrollmentService.getStudentTraining(trainingId);
//		return ResponseEntity.ok(response);
//	}

}
