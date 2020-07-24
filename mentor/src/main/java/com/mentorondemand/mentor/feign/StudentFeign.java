package com.mentorondemand.mentor.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mentorondemand.mentor.dto.StudentTrainingDTO;

@FeignClient("student-service")
public interface StudentFeign {
	@GetMapping(path = "/api/studenttraining")
	public List<StudentTrainingDTO> getPendingApprovals(@RequestParam("courseApprovalStatus") String status,
			@RequestParam("mentorTrainingId") Integer id);

}
