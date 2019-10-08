package com.pos.dao.model.mappers;

import com.pos.dao.model.Categorie;
import com.pos.dao.model.dto.CategorieDto;

public interface ICategorieMapper {
	Categorie mapToEntity(CategorieDto categoriedto) throws Exception;
	CategorieDto mapToDto(Categorie categorie) throws Exception;
}
