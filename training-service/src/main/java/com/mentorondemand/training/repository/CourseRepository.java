package com.mentorondemand.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentorondemand.training.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Course findById(Integer courseId);

}
