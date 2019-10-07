package com.pos.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pos.dao.model.Article;
import com.pos.dao.model.dto.ArticleDto;
import com.pos.dao.model.mappers.ArticleMapper;
import com.pos.dao.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public ArticleDto addOrUpdateArticle(ArticleDto articledto) throws IllegalAccessException, InvocationTargetException {
		Article article = articleMapper.mapToEntity(articledto);
		article = articleRepository.save(article);
		articledto = articleMapper.mapToDto(article);
		return articledto;
	}


	public List<ArticleDto> getAllArticles() {
		List<Article> articles = articleRepository.findAll();
		List<ArticleDto> articlesdto = new ArrayList<>();
		articles.forEach(article -> articlesdto.add(articleMapper.mapToDto(article)) );
		return articlesdto;
	}
	
	
	public List<ArticleDto> getAllArticlesByPagination(int start, int end) {
		Pageable articlepage = PageRequest.of(start, end);
		Page<Article> pagearticles = articleRepository.findAll(articlepage);
		List<ArticleDto> articlesdto = new ArrayList<>();
		pagearticles.forEach(article -> articlesdto.add(articleMapper.mapToDto(article)) );
		return articlesdto;
	}
	
	public List<ArticleDto> getAllArticlesByPaginationAndSorting(int start, int end, String sortby, String asc) {
		Pageable articlepage = PageRequest.of(start, end,"asc".equals(asc)?Sort.by(sortby).ascending():Sort.by(sortby).descending());
		Page<Article> pagearticles = articleRepository.findAll(articlepage);
		List<ArticleDto> articlesdto = new ArrayList<>();
		pagearticles.forEach(article -> articlesdto.add(articleMapper.mapToDto(article)) );
		return articlesdto;
	}


	public ArticleDto getArticle(long id) {
		Optional<Article> optionalarticle = articleRepository.findById(id);
		return optionalarticle.isPresent()?articleMapper.mapToDto(optionalarticle.get()):null;
	}

}
