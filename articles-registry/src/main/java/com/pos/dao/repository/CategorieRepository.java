package com.pos.dao.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pos.dao.model.Categorie;

@Transactional
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
		Page<Categorie> findAll(Pageable pageable);

}
