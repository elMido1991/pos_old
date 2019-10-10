package com.pos.dao.model.mappers;

import com.pos.dao.model.Stock;
import com.pos.dao.model.dto.StockDto;

public interface StockMapper {
	Stock mapToEntity(StockDto stockDto);
	StockDto mapToDto(Stock stock);
}
