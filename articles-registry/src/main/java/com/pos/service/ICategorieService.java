package com.pos.service;

import java.util.List;

import com.pos.dao.model.dto.CategorieDto;

public interface ICategorieService {
	CategorieDto addOrUpdateCategorie(CategorieDto categoriedto) throws Exception;
	List<CategorieDto> getAllCategories() throws Exception;
	List<CategorieDto> getAllCategoriesByPagination(int start, int end) throws Exception;
	List<CategorieDto> getAllCategoriesByPaginationAndSorting(int start, int end, String sortby, String asc) throws Exception;
	CategorieDto getCategorie(long id) throws Exception;
}
