package com.mentorondemand.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.student.domain.StudentTraining;

@Repository
public interface StudentTrainingRepository extends JpaRepository<StudentTraining, Long>{

	StudentTraining findById(Integer trainingId);

	List<StudentTraining> findByCourseApprovalStatusAndMentorTrainingId(String courseApprovalStatus,
			Integer mentorTrainingId);

}
