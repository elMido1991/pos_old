package com.pos.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.pos.dao.model.dto.CategorieDto;

public interface ICategorieService {
	CategorieDto addOrUpdateCategorie(CategorieDto categoriedto) throws IllegalAccessException, InvocationTargetException;
	List<CategorieDto> getAllCategories();
	List<CategorieDto> getAllCategoriesByPagination(int start, int end);
	List<CategorieDto> getAllCategoriesByPaginationAndSorting(int start, int end, String sortby, String asc);
	CategorieDto getCategorie(long id);
}
