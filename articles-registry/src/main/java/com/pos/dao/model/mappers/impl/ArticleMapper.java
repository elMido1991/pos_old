package com.pos.dao.model.mappers.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pos.dao.model.Article;
import com.pos.dao.model.dto.ArticleDto;
import com.pos.dao.model.mappers.IArticleMapper;

@Component
public class ArticleMapper implements IArticleMapper {
	
	@Autowired
	private CategorieMapper categorieMapper;
	
	public Article mapToEntity(ArticleDto articledto) throws Exception {
		Article article = new Article();
		BeanUtils.copyProperties(articledto, article);
		article.setCategorie(categorieMapper.mapToEntity(articledto.getCategorieDto()));
		return article;
	}
	
	
	public ArticleDto mapToDto(Article article) throws Exception{
		ArticleDto articledto = new ArticleDto();
		BeanUtils.copyProperties(article, articledto);
		articledto.setCategorieDto(categorieMapper.mapToDto(article.getCategorie()));
		return articledto;
	}
	
	

}
