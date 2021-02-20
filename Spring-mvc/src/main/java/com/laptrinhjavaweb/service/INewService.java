package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;

public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	NewDTO findOne(long id);
	int getTotalItem();
	NewDTO insert(NewDTO insertNew);
	NewDTO update(NewDTO updateNew);
	NewDTO save(NewDTO saveOrUpdateNew);
	void delete(long ids[]);
}
