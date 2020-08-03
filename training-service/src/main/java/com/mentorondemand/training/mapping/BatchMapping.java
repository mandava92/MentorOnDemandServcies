package com.mentorondemand.training.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.training.domain.Batches;
import com.mentorondemand.training.dto.BatchDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BatchMapping {
	BatchDTO batchToBatchDto(Batches skill);
	List<BatchDTO> batchToBatchDtos(List<Batches> skill);
	Batches batchToBatchDto(BatchDTO batchDTO);
}
