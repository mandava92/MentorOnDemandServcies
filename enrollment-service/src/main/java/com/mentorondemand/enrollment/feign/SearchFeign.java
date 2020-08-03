package com.mentorondemand.enrollment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mentorondemand.enrollment.dto.CourseIndexDTO;




@FeignClient("search-service")
public interface SearchFeign {
	
	@PutMapping(path = "/api/search/courses")
	void updateCourseSearch(@RequestBody CourseIndexDTO courseIndexDto);

}
