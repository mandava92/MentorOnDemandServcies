package com.mentorondemand.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mentorondemand.admin.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

	Course findById(Integer courseId);

}
