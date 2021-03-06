package com.kts.Restaurant.util.mapper;

import com.kts.Restaurant.dto.TableDTO;
import com.kts.Restaurant.model.Table;
import com.kts.Restaurant.util.DTOMapperInterface;

public class TableMapper implements DTOMapperInterface<Table, TableDTO> {

	OrderMapper orderMapper = new OrderMapper();
	@Override
	public Table toEntity(TableDTO dto) {
		return new Table(dto.getTableId(), dto.getX(), dto.getY(), dto.getName());
	}

	@Override
	public TableDTO toDto(Table entity) {
		return new TableDTO(entity.getId(), entity.getType().getId(), entity.getX(), entity.getY(),entity.getType().getNumOfSeats(), entity.getType().getIcon(), orderMapper.toDto(entity.getOrder()), entity.getName());
	}

}
