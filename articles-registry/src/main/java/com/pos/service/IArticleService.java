package com.pos.service;

import java.util.List;

import com.pos.dao.model.dto.ArticleDto;

public interface IArticleService {
	 ArticleDto addOrUpdateArticle(ArticleDto articledto) throws Exception;
	 List<ArticleDto> getAllArticles() throws Exception;
	 List<ArticleDto> getAllArticlesByPagination(int start, int end) throws Exception;
	 List<ArticleDto> getAllArticlesByPaginationAndSorting(int start, int end, String sortby, String asc) throws Exception;
	 ArticleDto getArticle(long id) throws Exception;
}
