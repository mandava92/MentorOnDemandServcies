package com.mentorondemand.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorondemand.training.domain.Batches;
import com.mentorondemand.training.dto.BatchDTO;
import com.mentorondemand.training.mapping.BatchMapping;
import com.mentorondemand.training.repository.BatchRepository;

@Service
public class BatchServiceImpl implements BatchService{
	
	@Autowired
	private BatchRepository repository;
	
	@Autowired
	private BatchMapping mapper;

	public BatchDTO getBatch(Integer batchId) {
		Batches batch = repository.findById(batchId);
		return mapper.batchToBatchDto(batch);
	}

	public List<BatchDTO> getBatches() {
		List<Batches> batches = repository.findAll();
		return mapper.batchToBatchDtos(batches);
	}

	@Override
	public BatchDTO createBatch(BatchDTO batchDTO) {
		Batches batch = mapper.batchToBatchDto(batchDTO);
		batch = repository.save(batch);
		return mapper.batchToBatchDto(batch);
	}

	@Override
	public BatchDTO updateBatch(BatchDTO batchDTO) {
		Batches batch = mapper.batchToBatchDto(batchDTO);
		batch = repository.save(batch);
		return mapper.batchToBatchDto(batch);
	}

}
