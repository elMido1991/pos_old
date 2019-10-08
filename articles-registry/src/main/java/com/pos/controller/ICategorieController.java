package com.pos.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.dao.model.dto.CategorieDto;

public interface ICategorieController {
	
	ResponseEntity<String> addCategorie(@RequestBody CategorieDto categoriedto) throws IllegalAccessException, InvocationTargetException, Exception ;
	ResponseEntity<String> updateCategorie(@PathVariable long id,@RequestBody CategorieDto categoriedto) throws IllegalAccessException, InvocationTargetException, Exception;
	@ResponseBody List<CategorieDto> getAllCategories() throws Exception ;
	@ResponseBody CategorieDto getCategorie(@PathVariable long id) throws Exception ;
	@ResponseBody List<CategorieDto> getCategoriesByPagination(@PathVariable int start,@PathVariable int end) throws Exception ;
	@ResponseBody List<CategorieDto> getCategoriesByPaginationAndSort(@PathVariable int start,@PathVariable int end, @PathVariable String sortby, @PathVariable String asc) throws Exception ;

}
