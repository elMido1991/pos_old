package com.pos.dao.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String designation;
	private String description;
	private float price;
	private float quantity;
	private String image;
	private CategorieDto categorieDto;
	
	
}
