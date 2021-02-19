package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;

//import com.laptrinhjavaweb.model.NewModel;
//import com.laptrinhjavaweb.service.INewService;

@Controller(value="newControllerOfAdmin")
public class NewController {
	@Autowired
	private INewService iNewService;
	
	@Autowired 
	private ICategoryService iCategoryService;
	@RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page) { //limit neu request tu client
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(4);
		Pageable pageable = new PageRequest(page - 1, model.getLimit());
		model.setListResult(iNewService.findAll(pageable));
        ModelAndView mav = new ModelAndView("admin/new/list");
        model.setTotalItems(iNewService.getTotalItem());
		//ham ceil tra ve integer ma lon hon hoac bang tham so 
        model.setTotalPage((int) Math.ceil((double) model.getTotalItems() / model.getLimit()));
        mav.addObject("model", model); 
        return mav;
    }
	
	//required = false check id null or notnull, notnull thi khong lay
	@RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
    public ModelAndView showEdit(@RequestParam(value = "id", required = false) Long id) {
		NewDTO model = new NewDTO();
		CategoryDTO category = new CategoryDTO();
		if (id != null) {
			model = iNewService.findOne(id);
		}
		//ham ceil tra ve integer ma lon hon hoac bang tham so 
        ModelAndView ma = new ModelAndView("admin/new/edit");
		ma.addObject("model", model); 
		ma.addObject("categories", iCategoryService.findAll()); 
        return ma;
    }
}
