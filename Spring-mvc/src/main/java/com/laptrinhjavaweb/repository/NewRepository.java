package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

//Serializable khai bao kieu du lieu cua khoa chinh
public interface NewRepository extends JpaRepository<NewEntity, Long> {
    
}
