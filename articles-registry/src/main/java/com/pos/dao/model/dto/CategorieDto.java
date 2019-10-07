package com.pos.dao.model.dto;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
	
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String libelle;
	private Set<ArticleDto> articlesdto;
}
