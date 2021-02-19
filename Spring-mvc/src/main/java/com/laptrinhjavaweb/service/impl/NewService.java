package com.laptrinhjavaweb.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private NewConverter newConverter;
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
//		return newDao.findAll();
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent(); //ham findAll return ra c�c class implement interface list
		for (NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count(); //dem tong so item	
	}

	@Override
	public NewDTO findOne(long id) {
		NewEntity newEntity = new NewEntity();
		newEntity = newRepository.findOne((long) id); //ham findAll return ra c�c class implement interface list
//			NewDTO newDTO = new NewDTO();
//			newDTO.setCategoryCode(newEntity.getCategory().getCode());
//			newDTO.setId(newEntity.getId());
//			newDTO.setTitle(newEntity.getTitle());
//			newDTO.setShortDescription(newEntity.getShortDescription());
//			newDTO.setContent(newEntity.getContent());
//			newDTO.setThumbnail(newEntity.getThumbnail());
		NewDTO newDTO = newConverter.toDTO(newEntity);
		return newDTO;
	}

	@Override
	@Transactional //xu ly transaction
	public NewDTO insert(NewDTO insertNew) {
		CategoryEntity categoryEntity = categoryRepository.findOneByCategoryCode(insertNew.getCategoryCode());
		NewEntity newEntity = newConverter.toEntity(insertNew, categoryEntity);
		newEntity = newRepository.save(newEntity);
		insertNew = newConverter.toDTO(newEntity);
		return insertNew;
	}

	@Override
	@Transactional
	public NewDTO update(NewDTO updateNew) {
		NewEntity oldNew = newRepository.findOne(updateNew.getId());
		NewEntity newNew = new NewEntity();
		CategoryEntity categoryEntity = categoryRepository.findOneByCategoryCode(updateNew.getCategoryCode()); //Muc dich de lay categoryID
		newNew = newConverter.toEntity(updateNew, categoryEntity, oldNew);// dung ham nay vi phai dua tren newEntity cu.
		return newConverter.toDTO(newRepository.save(newNew));
	}
}

// search mapping from ENTITY to DTO (convert)
