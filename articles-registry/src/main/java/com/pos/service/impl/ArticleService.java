package com.pos.service.impl;

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
import com.pos.dao.model.mappers.impl.ArticleMapper;
import com.pos.dao.repository.ArticleRepository;
import com.pos.service.IArticleService;

@Service
public class ArticleService implements IArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public ArticleDto addOrUpdateArticle(ArticleDto articledto) throws Exception {
		Article article = articleMapper.mapToEntity(articledto);
		article = articleRepository.save(article);
		articledto = articleMapper.mapToDto(article);
		return articledto;
	}


	public List<ArticleDto> getAllArticles() throws Exception {
		List<Article> articles = articleRepository.findAll();
		List<ArticleDto> articlesdto = new ArrayList<>();
		articles.forEach(article -> {
			try {
				articlesdto.add(articleMapper.mapToDto(article));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return articlesdto;
	}
	
	
	public List<ArticleDto> getAllArticlesByPagination(int start, int end) throws Exception {
		Pageable articlepage = PageRequest.of(start, end);
		Page<Article> pagearticles = articleRepository.findAll(articlepage);
		List<ArticleDto> articlesdto = new ArrayList<>();
		pagearticles.forEach(article -> {
			try {
				articlesdto.add(articleMapper.mapToDto(article));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return articlesdto;
	}
	
	public List<ArticleDto> getAllArticlesByPaginationAndSorting(int start, int end, String sortby, String asc) {
		Pageable articlepage = PageRequest.of(start, end,"asc".equals(asc)?Sort.by(sortby).ascending():Sort.by(sortby).descending());
		Page<Article> pagearticles = articleRepository.findAll(articlepage);
		List<ArticleDto> articlesdto = new ArrayList<>();
		pagearticles.forEach(article -> {
			try {
				articlesdto.add(articleMapper.mapToDto(article));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return articlesdto;
	}


	public ArticleDto getArticle(long id) throws Exception {
		Optional<Article> optionalarticle = articleRepository.findById(id);
		return optionalarticle.isPresent()? articleMapper.mapToDto(optionalarticle.get()):null;
	}

}
