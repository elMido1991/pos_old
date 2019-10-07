package com.pos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pos.dao.model.Article;
import com.pos.dao.model.Categorie;
import com.pos.dao.repository.ArticleRepository;
import com.pos.dao.repository.CategorieRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ArticlesRegistryApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ArticlesRegistryApplication.class, args);
	}

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Categorie categorie1 = Categorie.builder().id(0).libelle("cat1").build();
		categorieRepository.save(categorie1);
		Categorie categorie2 = Categorie.builder().id(0).libelle("cat2").build();
		categorieRepository.save(categorie2);
		Categorie categorie3 = Categorie.builder().id(0).libelle("cat3").build();
		categorieRepository.save(categorie3);
		
		Article article1 = Article.builder().id(0).designation("article 100").description("description 100").price(120).quantity(200).image("image 100").categorie(categorie1).build();
		articleRepository.save(article1);
		Article article2 = Article.builder().id(0).designation("article 101").description("description 100").price(121).quantity(300).image("image 101").categorie(categorie2).build();
		articleRepository.save(article2);
		Article article3 = Article.builder().id(0).designation("article 102").description("description 100").price(122).quantity(400).image("image 102").categorie(categorie3).build();
		articleRepository.save(article3);
		Article article4 = Article.builder().id(0).designation("article 103").description("description 100").price(123).quantity(500).image("image 103").categorie(categorie1).build();
		articleRepository.save(article4);
		Article article5 = Article.builder().id(0).designation("article 104").description("description 100").price(124).quantity(600).image("image 104").categorie(categorie2).build();
		articleRepository.save(article5);
		Article article6 = Article.builder().id(0).designation("article 105").description("description 100").price(125).quantity(700).image("image 105").categorie(categorie3).build();
		articleRepository.save(article6);
	}

}
