package com.laptrinhjavaweb.dao;
import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO  extends GenericDAO<NewModel>{

	//List<NewModel> findAll(Integer offset, Integer limit, String sortName, String sortBy);
	List<NewModel> findAll();

}
