package com.pos.service;

import java.util.Set;

import com.pos.dao.model.dto.EntrepotDto;

public interface IEntrepotService {
	EntrepotDto addEntrepot(EntrepotDto entrepotDto);
	EntrepotDto updateEntrepot(long idEntrepot, EntrepotDto entrepotDto);
	void deleteEntrepot(long idEntrepot);
	EntrepotDto getEntrepot(long idEntrepot);
	Set<EntrepotDto> getEntrepots(long ...idEntrepot);
}
