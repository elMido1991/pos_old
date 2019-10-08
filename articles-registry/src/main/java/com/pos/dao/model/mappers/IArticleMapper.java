package com.pos.dao.model.mappers;

import com.pos.dao.model.Article;
import com.pos.dao.model.dto.ArticleDto;

public interface IArticleMapper {
	Article mapToEntity(ArticleDto articledto) throws Exception;
	ArticleDto mapToDto(Article article) throws Exception;
}
