package com.pos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pos.dao.model.dto.ArticleDto;

public interface IArticleController {
	ResponseEntity<String> addArticle(@RequestBody ArticleDto articledto) throws Exception ;
	ResponseEntity<String> updateArticle(@PathVariable long id,@RequestBody ArticleDto articledto) throws Exception;
	@ResponseBody List<ArticleDto> getAllArticles() throws Exception ;
	@ResponseBody ArticleDto getArticle(@PathVariable long id) throws Exception ;
	@ResponseBody List<ArticleDto> getArticlesByPagination(@PathVariable int start,@PathVariable int end) throws Exception ;
	@ResponseBody List<ArticleDto> getArticlesByPaginationAndSort(@PathVariable int start,@PathVariable int end, @PathVariable String sortby, @PathVariable String asc) throws Exception ;
}
