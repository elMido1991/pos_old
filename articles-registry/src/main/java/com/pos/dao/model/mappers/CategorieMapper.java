package com.pos.dao.model.mappers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pos.dao.model.Categorie;
import com.pos.dao.model.dto.CategorieDto;

@Component
public class CategorieMapper {
	
	
	
	public Categorie mapToEntity(CategorieDto categoriedto) throws IllegalAccessException, InvocationTargetException {
		Categorie categorie = new Categorie();
		BeanUtils.copyProperties(categoriedto, categorie);
		return categorie;
	}
	
	
	public CategorieDto mapToDto(Categorie categorie) {
		CategorieDto categoriedto = new CategorieDto();
		BeanUtils.copyProperties(categorie, categoriedto);
		return categoriedto;
	}
	
	

}
