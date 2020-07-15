package com.mentorondemand.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.admin.dto.CourseDTO;
import com.mentorondemand.admin.service.CourseService;

@RestController
@RequestMapping(value = "/api/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping(value = "/createCourse")
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
		courseService.createCourse(courseDTO);
		return null;
	}

	@PutMapping(value = "/createCourse")
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
		courseService.updateCourse(courseDTO);
		return null;
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Integer courseId) {
		courseService.getCourse(courseId);
		return null;
	}

	@GetMapping(value = "/getCourses")
	public ResponseEntity<CourseDTO> getCourses() {
		courseService.getCourses();
		return null;
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CourseDTO> deleteCourse(@PathVariable Integer courseId) {
		courseService.deleteCourse(courseId);
		return null;
	}

}
