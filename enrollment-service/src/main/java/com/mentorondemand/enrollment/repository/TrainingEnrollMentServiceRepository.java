package com.mentorondemand.enrollment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.enrollment.domain.TrainingEnrollment;

@Repository
public interface TrainingEnrollMentServiceRepository extends JpaRepository<TrainingEnrollment, Long>{

	TrainingEnrollment findById(Integer trainingId);

	List<TrainingEnrollment> findByCourseApprovalStatusAndCourseId(String courseApprovalStatus,
			Integer courseId);

}
