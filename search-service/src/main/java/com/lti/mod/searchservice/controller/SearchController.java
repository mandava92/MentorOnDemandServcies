package com.lti.mod.searchservice.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.mod.searchservice.dto.CourseIndexDTO;
import com.lti.mod.searchservice.dto.CourseUpdateIndexDTO;
import com.lti.mod.searchservice.service.SearchService;

import io.searchbox.core.SearchResult.Hit;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/search")
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@PostMapping("/courses")
	public ResponseEntity<HttpStatus> createIndex(@RequestBody CourseIndexDTO course) throws Exception{
		searchService.createUpdateIndex(course);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	@PostMapping("/courses/{corename}/setup")
//	public ResponseEntity<HttpStatus> createIndexSetup(@PathVariable String corename ) throws Exception{
//		searchService.createIndexSetup(corename);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}
	
	@PutMapping("/courses")
	public ResponseEntity<String> updateIndex(@RequestBody CourseUpdateIndexDTO course) throws Exception{
		searchService.updateTraineeDetails(course);
		return ResponseEntity.ok("Update successfully");
	}
	
	@GetMapping("/courses")
	public ResponseEntity<List<CourseIndexDTO>> getAllCourses() throws Exception{
		return ResponseEntity.ok(searchService.getAllCourses());
	}
	
	@GetMapping("/courses/pending/mentor/{mentorUserName}")
	public ResponseEntity<List<CourseIndexDTO>> allPendingApprovalCourses(@PathVariable String mentorUserName) throws Exception{
		return ResponseEntity.ok(searchService.allPendingApprovalCourses(mentorUserName));
	}
	
	@GetMapping("/courses/aproved/mentor/{mentorUserName}")
	public ResponseEntity<List<CourseIndexDTO>> getAllTrainees(@PathVariable String mentorUserName) throws Exception{
		return ResponseEntity.ok(searchService.getAllTrainees(mentorUserName));
	}
	
	@GetMapping("/courses/pending/trainee/{traineeUserName}")
	public ResponseEntity<List<CourseIndexDTO>> studentPendingApprovalCourses(@PathVariable String traineeUserName) throws Exception{
		return ResponseEntity.ok(searchService.studentPendingApprovalCourses(traineeUserName));
	}
	
	@GetMapping("/courses/new/trainee/{traineeUserName}")
	public ResponseEntity<List<CourseIndexDTO>> studentNewCourses(@PathVariable String traineeUserName) throws Exception{
		return ResponseEntity.ok(searchService.studentNewCourses(traineeUserName));
	}
	
	@GetMapping("/courses/current/trainee/{traineeUserName}")
	public ResponseEntity<List<CourseIndexDTO>> studentCurrentCourses(@PathVariable String traineeUserName) throws Exception{
		return ResponseEntity.ok(searchService.studentCurrentCourses(traineeUserName));
	}
	
	@GetMapping("/courses/{id}")
	public ResponseEntity<CourseIndexDTO> getCourseById(@PathVariable String id) throws Exception{
		return ResponseEntity.ok(searchService.getCourseById(id));
	}
	
	@GetMapping("/courses/{query}/search")
	public ResponseEntity<List<CourseIndexDTO>> searchCourse() throws Exception{
		///Incompleted method...Search with any text should be implemented here
		return ResponseEntity.ok(searchService.getAllCourses());
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable String id) throws IOException {
		searchService.deleteIndex(id);
	}
}
