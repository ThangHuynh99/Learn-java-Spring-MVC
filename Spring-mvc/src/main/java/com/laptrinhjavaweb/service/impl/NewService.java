package com.laptrinhjavaweb.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Service
public class NewService implements INewService{

	@Autowired
	private NewRepository newRepository;
	
	@Override
	public List<NewDTO> findAll(Pageable pageable) {
//		return newDao.findAll();
		List<NewDTO> models = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent(); //ham findAll return ra c�c class implement interface list
		for (NewEntity item: entities) {
			NewDTO newDTO = new NewDTO();
			newDTO.setTitle(item.getTitle());
			newDTO.setShortDescription(item.getShortDescription());
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count(); //dem tong so item	
	}
}

// search mapping from ENTITY to DTO (convert)
