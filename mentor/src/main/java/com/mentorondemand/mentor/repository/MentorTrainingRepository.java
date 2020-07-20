package com.mentorondemand.mentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.mentor.domain.MentorTraining;

@Repository
public interface MentorTrainingRepository extends JpaRepository<MentorTraining, Long>{

	MentorTraining findById(Integer id);

}
