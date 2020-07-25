package com.mentorondemand.mentor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mentorondemand.mentor.dto.CourseIndexDTO;

@FeignClient("search-service")
public interface SearchFeign {
	
	@PostMapping(path = "/api/search/courses")
	void updateCourseSearch(@RequestBody CourseIndexDTO courseIndexDto);

}
