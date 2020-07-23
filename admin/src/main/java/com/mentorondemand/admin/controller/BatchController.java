package com.mentorondemand.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
		batchService.getBatch(batchId);
		return null;
	}
	
	@GetMapping()
	public ResponseEntity<List<BatchDTO>> getBatches(){
		batchService.getBatches();
		return null;
	}

}
