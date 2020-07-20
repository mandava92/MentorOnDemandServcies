package com.mentorondemand.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.admin.domain.Course;
import com.mentorondemand.admin.dto.CourseDTO;
import com.mentorondemand.admin.mapping.CourseMapper;
import com.mentorondemand.admin.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CourseMapper courseMapper;

	public CourseDTO createCourse(CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
		course = courseRepository.save(course);
		return courseMapper.courseToCourseDto(course);
	}

	public CourseDTO updateCourse(CourseDTO courseDTO) {
		Course course = courseMapper.courseDtoToCourse(courseDTO);
		course = courseRepository.save(course);
		return courseMapper.courseToCourseDto(course);
	}

	public CourseDTO getCourse(Integer courseId) {
		Course course = courseRepository.findById(courseId);
		return courseMapper.courseToCourseDto(course);
	}

	public List<CourseDTO> getCourses() {
		List<Course> courses = courseRepository.findAll();
		return courseMapper.courseToCourseDtos(courses);
	}

	public void deleteCourse(Integer courseId) {
		Course course = courseRepository.findById(courseId);
		courseRepository.delete(course);
		
	}

}
