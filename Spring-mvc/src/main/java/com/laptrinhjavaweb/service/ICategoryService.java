package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {
//	List<CategoryModel> findAll();
	CategoryModel findOne(long id);
	List<CategoryDTO> findAllCategory();
	Map<String, String> findAll();
	
	//ham nay dung de lay categoryID dung de insert vao bang API
	CategoryModel findOneByCode(String code);
	
}
