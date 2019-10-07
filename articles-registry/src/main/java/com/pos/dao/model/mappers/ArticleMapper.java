package com.pos.dao.model.mappers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.pos.dao.model.Article;
import com.pos.dao.model.dto.ArticleDto;

@Component
public class ArticleMapper {
	
	
	
	public Article mapToEntity(ArticleDto articledto) throws IllegalAccessException, InvocationTargetException {
		Article article = new Article();
		BeanUtils.copyProperties(articledto, article);
		return article;
	}
	
	
	public ArticleDto mapToDto(Article article) {
		ArticleDto articledto = new ArticleDto();
		BeanUtils.copyProperties(article, articledto);
		return articledto;
	}
	
	

}
