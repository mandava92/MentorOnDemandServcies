package com.mentorondemand.mentor.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mentorondemand.mentor.dto.BatchDTO;
import com.mentorondemand.mentor.dto.CourseDTO;

@FeignClient("admin-service")
public interface AdminFeign {
	@GetMapping(path = "/api/studenttraining/courses")
	public List<CourseDTO> getCourses(@RequestParam("courses") List<Integer> courses);
	@GetMapping(path = "/api/studenttraining/batches")
	public List<BatchDTO> getBatches(@RequestParam("batches") List<Integer> batches);
}
