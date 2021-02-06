package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

@Repository
public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {
	@Autowired
	private GenericDAO<NewModel> generic;
	
	//khong khoi tao interface trong class implements
	//ham moi
	@Override
	public List<NewModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return generic.query(sql.toString(), new NewMapper());
//		return query(sql.toString(), new NewMapper());
	}
}
