package com.mentorondemand.training.controller;

import java.util.List;

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

import com.mentorondemand.training.dto.CourseDTO;
import com.mentorondemand.training.service.CourseService;

@RestController
@RequestMapping(value = "/api/admin/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
		CourseDTO course = courseService.createCourse(courseDTO);
		return ResponseEntity.ok(course);
	}

	@PutMapping
	public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
		CourseDTO course = courseService.updateCourse(courseDTO);
		return ResponseEntity.ok(course);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Integer id) {
		CourseDTO course = courseService.getCourse(id);
		return ResponseEntity.ok(course);
	}

	@GetMapping
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<CourseDTO> courses = courseService.getCourses();
		return ResponseEntity.ok(courses);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courseService.deleteCourse(id);
		
	}

}
