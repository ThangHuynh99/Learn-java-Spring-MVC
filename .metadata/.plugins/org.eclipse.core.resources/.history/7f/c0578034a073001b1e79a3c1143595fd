package com.laptrinhjavaweb.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
		
	
	}
	
	@GetMapping("/api/new")
	public List<NewDTO> getNew(@RequestBody long[] ids) {
		
		return null;
	}
}
