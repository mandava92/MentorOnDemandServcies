package com.mentorondemand.training.service;

import java.util.List;

import com.mentorondemand.training.dto.CourseDTO;

public interface CourseService {
	public CourseDTO createCourse(CourseDTO course);
	public CourseDTO updateCourse(CourseDTO course);
	public CourseDTO getCourse(Integer courseId);
	public List<CourseDTO> getCourses();
	public void deleteCourse(Integer courseId);
}
