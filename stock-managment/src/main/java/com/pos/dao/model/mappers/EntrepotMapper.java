package com.pos.dao.model.mappers;

import com.pos.dao.model.Entrepot;
import com.pos.dao.model.dto.EntrepotDto;

public interface EntrepotMapper {

	Entrepot mapToEntity(EntrepotDto entrepotDto);
	EntrepotDto mapToDto(Entrepot entrepot);
}
