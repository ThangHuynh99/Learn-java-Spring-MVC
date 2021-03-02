package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.admin.output.OutputNew;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController(value = "NewAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService iNewService;
	@PostMapping("/api/new")
	public NewDTO createNew(@RequestBody NewDTO newDTO) {
		
		return iNewService.insert(newDTO);
	}
	
	@PutMapping("/api/new")
	public NewDTO updateNew(@RequestBody NewDTO newDTO) {	
		return iNewService.update(newDTO);
	}
	
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		iNewService.delete(ids);
	}
	
	@GetMapping(value = "/new")
	public OutputNew showNew(@RequestParam(value = "page", defaultValue = "1") int page,
				@RequestParam(value = "limit", defaultValue = "4") int limit) {
		OutputNew output = new OutputNew();
		output.setPage(page);
		output.setTotalPage((int) Math.ceil((double) (iNewService.getTotalItem()) / limit));
		Pageable pageable = new PageRequest(page - 1, limit);
		output.setListResult(iNewService.findAll(pageable));
		return output;
	}
}
