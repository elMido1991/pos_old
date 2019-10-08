package com.pos.controller.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.controller.ICategorieController;
import com.pos.dao.model.dto.CategorieDto;
import com.pos.service.impl.CategorieService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/categories")
@Controller
public class CategorieController implements ICategorieController {

	@Autowired
	private CategorieService categorieService;
	
	@PostMapping(value= "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "add article")
	public ResponseEntity<String> addCategorie(@RequestBody CategorieDto categoriedto) throws IllegalAccessException, InvocationTargetException,Exception {
		if(Optional.ofNullable(categorieService.addOrUpdateCategorie(categoriedto)).isPresent())
			return ResponseEntity.ok().body("Categorie created");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Categorie not created");
	}
	
	
	@PutMapping(value= "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "update categorie")
	public ResponseEntity<String> updateCategorie(@PathVariable long id,@RequestBody CategorieDto categoriedto) throws IllegalAccessException, InvocationTargetException,Exception {
		categoriedto.setId(id);
		if(Optional.ofNullable(categorieService.addOrUpdateCategorie(categoriedto)).isPresent())
			return ResponseEntity.ok().body("Categorie updated");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Categorie not updated");
	}
	
	
	@GetMapping(value= "/all",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get all categories")
	public @ResponseBody List<CategorieDto> getAllCategories() throws Exception {
		return categorieService.getAllCategories();
	}
	
	@GetMapping(value= "/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get one categorie")
	public @ResponseBody CategorieDto getCategorie(@PathVariable long id) throws Exception {
		return categorieService.getCategorie(id);
	}
	
	@GetMapping(value= "/find/{start}/{end}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get categories by pagination")
	public @ResponseBody List<CategorieDto> getCategoriesByPagination(@PathVariable int start,@PathVariable int end) throws Exception {
		return categorieService.getAllCategoriesByPagination(start, end);
	}
	
	@GetMapping(value= "/find/{start}/{end}/{sortby}/{asc}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "get categories by pagination with sorting")
	public @ResponseBody List<CategorieDto> getCategoriesByPaginationAndSort(@PathVariable int start,@PathVariable int end, @PathVariable String sortby, @PathVariable String asc) throws Exception {
		return categorieService.getAllCategoriesByPaginationAndSorting(start, end,sortby,asc);
	}
	
	
}
