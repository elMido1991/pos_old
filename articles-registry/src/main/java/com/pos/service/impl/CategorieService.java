package com.pos.service.impl;

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

import com.pos.dao.model.Categorie;
import com.pos.dao.model.dto.CategorieDto;
import com.pos.dao.model.mappers.impl.CategorieMapper;
import com.pos.dao.repository.CategorieRepository;
import com.pos.service.ICategorieService;

@Service
public class CategorieService implements ICategorieService {

	@Autowired
	private CategorieMapper categorieMapper;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	public CategorieDto addOrUpdateCategorie(CategorieDto categoriedto) throws Exception {
		Categorie categorie = categorieMapper.mapToEntity(categoriedto);
		categorie = categorieRepository.save(categorie);
		categoriedto = categorieMapper.mapToDto(categorie);
		return categoriedto;
	}


	public List<CategorieDto> getAllCategories() {
		List<Categorie> categories = categorieRepository.findAll();
		List<CategorieDto> categoriesdto = new ArrayList<>();
		categories.forEach(categorie -> {
			try {
				categoriesdto.add(categorieMapper.mapToDto(categorie));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return categoriesdto;
	}
	
	
	public List<CategorieDto> getAllCategoriesByPagination(int start, int end) {
		Pageable categoriepage = PageRequest.of(start, end);
		Page<Categorie> pagecategories = categorieRepository.findAll(categoriepage);
		List<CategorieDto> categoriesdto = new ArrayList<>();
		pagecategories.forEach(categorie -> {
			try {
				categoriesdto.add(categorieMapper.mapToDto(categorie));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return categoriesdto;
	}
	
	public List<CategorieDto> getAllCategoriesByPaginationAndSorting(int start, int end, String sortby, String asc) {
		Pageable categoriepage = PageRequest.of(start, end,"asc".equals(asc)?Sort.by(sortby).ascending():Sort.by(sortby).descending());
		Page<Categorie> pagecategories = categorieRepository.findAll(categoriepage);
		List<CategorieDto> categoriesdto = new ArrayList<>();
		pagecategories.forEach(categorie -> {
			try {
				categoriesdto.add(categorieMapper.mapToDto(categorie));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
		return categoriesdto;
	}


	public CategorieDto getCategorie(long id) throws Exception {
		Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
		return optionalCategorie.isPresent()?categorieMapper.mapToDto(optionalCategorie.get()):null;
	}

}
