package com.pos.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.pos.dao.model.dto.ArticleDto;

public interface IArticleService {
	 ArticleDto addOrUpdateArticle(ArticleDto articledto) throws IllegalAccessException, InvocationTargetException;
	 List<ArticleDto> getAllArticles();
	 List<ArticleDto> getAllArticlesByPagination(int start, int end);
	 List<ArticleDto> getAllArticlesByPaginationAndSorting(int start, int end, String sortby, String asc);
	 ArticleDto getArticle(long id);
}
