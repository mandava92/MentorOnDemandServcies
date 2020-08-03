package com.mentorondemand.training.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mentorondemand.training.dto.CourseIndexDTO;



@FeignClient("search-service")
public interface SearchFeign {
	
	@PostMapping(path = "/api/search/courses")
	void updateCourseSearch(@RequestBody CourseIndexDTO courseIndexDto);
	
	@DeleteMapping(path ="/api/search/courses/{id}")
	void deleteCourse(@PathVariable String id);

}
