package com.mentorondemand.admin.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.admin.domain.Course;
import com.mentorondemand.admin.dto.CourseDTO;


@Mapper(componentModel = "spring", uses = {})
public interface CourseMapper {
	
 CourseDTO courseToCourseDto(Course course);
 Course courseDtoToCourse(CourseDTO course);
 
 List<CourseDTO> courseToCourseDtos(List<Course> course);
 List<Course> courseDtoToCourse(List<CourseDTO> course);
}
