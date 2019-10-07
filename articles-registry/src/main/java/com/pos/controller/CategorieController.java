package com.pos.controller;

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

import com.pos.dao.model.dto.ArticleDto;
import com.pos.service.ArticleService;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/articles")
@Controller
public class CategorieController {

	@Autowired
	private ArticleService articleService;
	
	@PostMapping(value= "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "")
	public ResponseEntity<String> addArticle(@RequestBody ArticleDto articledto) throws IllegalAccessException, InvocationTargetException {
		if(Optional.ofNullable(articleService.addOrUpdateArticle(articledto)).isPresent())
			return ResponseEntity.ok().body("Article created");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Article not created");
	}
	
	
	@PutMapping(value= "/update/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateArticle(@PathVariable long id,@RequestBody ArticleDto articledto) throws IllegalAccessException, InvocationTargetException {
		articledto.setId(id);
		if(Optional.ofNullable(articleService.addOrUpdateArticle(articledto)).isPresent())
			return ResponseEntity.ok().body("Article updated");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Article not updated");
	}
	
	
	@GetMapping(value= "/all",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ArticleDto> getAllArticles() {
		return articleService.getAllArticles();
	}
	
	@GetMapping(value= "/find/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ArticleDto getArticle(@PathVariable long id) {
		return articleService.getArticle(id);
	}
	
	@GetMapping(value= "/find/{start}/{end}",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ArticleDto> getArticlesByPagination(@PathVariable int start,@PathVariable int end) {
		return articleService.getAllArticlesByPagination(start, end);
	}
	
	@GetMapping(value= "/find/{start}/{end}/{sortby}/{asc}",produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ArticleDto> getArticlesByPaginationAndSort(@PathVariable int start,@PathVariable int end, @PathVariable String sortby, @PathVariable String asc) {
		return articleService.getAllArticlesByPaginationAndSorting(start, end,sortby,asc);
	}
	
	
}
