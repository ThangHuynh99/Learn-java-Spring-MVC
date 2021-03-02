package com.laptrinhjavaweb.api.admin.output;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.NewDTO;

public class OutputNew {
	private int page;
	private int totalPage;
	private List<NewDTO> listResult = new ArrayList<>();

	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public List<NewDTO> getListResult() {
		return listResult;
	}
	
	public void setListResult(List<NewDTO> listResult) {
		this.listResult = listResult;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
