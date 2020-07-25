package com.mentorondemand.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorondemand.admin.dto.BatchDTO;
import com.mentorondemand.admin.service.BatchService;

@RestController
@RequestMapping(value = "/api/admin/batch")
public class BatchController {
	
	@Autowired
	private BatchService batchService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<BatchDTO> getBatch(Integer batchId){
		BatchDTO batch = batchService.getBatch(batchId);
		return ResponseEntity.ok(batch);
	}
	
	@GetMapping
	public ResponseEntity<List<BatchDTO>> getBatches(){
		List<BatchDTO> batches = batchService.getBatches();
		return ResponseEntity.ok(batches);
	}
	
	@PostMapping()
	public ResponseEntity<BatchDTO> createBatch(@RequestBody BatchDTO batchDTO){
		BatchDTO batch = batchService.createBatch(batchDTO);
		return ResponseEntity.ok(batch);
	}
	
	@PutMapping()
	public ResponseEntity<BatchDTO> upateBatch(@RequestBody BatchDTO batchDTO){
		BatchDTO batch = batchService.createBatch(batchDTO);
		return ResponseEntity.ok(batch);
	}

}
