package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public CategoryModel findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> findAll() {
		Map<String, String> category = new HashMap<>();
		List<CategoryEntity> categories = categoryRepository.findAll(); //ham findAll return ra các class implement interface list
		for (CategoryEntity item: categories) {
//			CategoryDTO categoryDTO = new CategoryDTO();
//			categoryDTO.setId(item.getId());
//			categoryDTO.setCode(item.getCode());
//			categoryDTO.setName(item.getName());
			category.put(item.getCode(), item.getName());
		}
		return category;
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		
		return null;
	}

	@Override
	public List<CategoryDTO> findAllCategory() {
		List<CategoryEntity> categories = categoryRepository.findAll(); 
		List<CategoryDTO> category = new ArrayList<>();
		for (CategoryEntity item: categories) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setId(item.getId());
			categoryDTO.setCode(item.getCode());
			categoryDTO.setName(item.getName());
			category.add(categoryDTO);
		}
		return category;
	}

}
