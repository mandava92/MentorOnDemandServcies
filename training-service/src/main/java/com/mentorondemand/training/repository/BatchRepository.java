package com.mentorondemand.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentorondemand.training.domain.Batches;

@Repository
public interface BatchRepository extends JpaRepository<Batches, Long>{

	Batches findById(Integer batchId);

}
