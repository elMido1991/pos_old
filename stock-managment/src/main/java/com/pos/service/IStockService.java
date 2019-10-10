package com.pos.service;

import java.util.Set;

import com.pos.dao.model.dto.StockDto;

public interface IStockService {
	StockDto addQuantityToStock(long idArticle, double quantity);
	StockDto updateQuantityOfStock(long idArticle, double quantity);
	StockDto removeQuantityFromStock(long idArticle, double quantity);
	StockDto getStockOfArticle(long idArticle);
	Set<StockDto> getStockOfArticles(long ...idArticles);
}
