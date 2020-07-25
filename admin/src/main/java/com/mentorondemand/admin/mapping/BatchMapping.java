package com.mentorondemand.admin.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.mentorondemand.admin.domain.Batches;
import com.mentorondemand.admin.dto.BatchDTO;

@Mapper(componentModel = "spring", uses = {})
public interface BatchMapping {
	BatchDTO batchToBatchDto(Batches skill);
	List<BatchDTO> batchToBatchDtos(List<Batches> skill);
	Batches batchToBatchDto(BatchDTO batchDTO);
}
