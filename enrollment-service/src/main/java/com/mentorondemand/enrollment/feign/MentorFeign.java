package com.mentorondemand.enrollment.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mentorondemand.enrollment.dto.MentorTrainingDTO;

@FeignClient("mentor-service")
public interface MentorFeign {
	
	@GetMapping(path = "/api/mentor/{id}")
	MentorTrainingDTO getMentorTrainingDetails(@PathVariable Integer id);

	//MentorTrainingDTO getMentorTrainingDetails(Integer mentorTrainingId);

}
