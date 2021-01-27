package com.laptrinhjavaweb.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.service.INewService;

//import com.laptrinhjavaweb.model.NewModel;
//import com.laptrinhjavaweb.service.INewService;

@Controller(value="newControllerOfAdmin")
public class NewController {
	@Autowired
	private INewService iNewService;
	
	@RequestMapping(value = "/admin/new/list", method = RequestMethod.GET)
    public ModelAndView showList(@ModelAttribute("model") NewModel model) {
        ModelAndView mav = new ModelAndView("admin/new/list");
        model.setListResult(iNewService.findAll());
        mav.addObject("model", model);
        return mav;
    }
	
	@RequestMapping(value = "/admin/new/edit", method = RequestMethod.GET)
    public ModelAndView showEdit() {
        ModelAndView ma = new ModelAndView("admin/new/edit");
        return ma;
    }
}
