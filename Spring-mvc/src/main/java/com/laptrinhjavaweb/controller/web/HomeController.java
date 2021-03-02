package com.laptrinhjavaweb.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {   
	@Autowired
	private ICategoryService iCategoryService;
	//commit
	@Autowired
	private INewService iNewService;
	
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView homePage() {
    	CategoryDTO category = new CategoryDTO();
    	NewDTO news = new NewDTO();
    	Pageable pageable = new PageRequest(0, 9);
    	news.setListResult(iNewService.findAll(pageable));
    	category.setListResult(iCategoryService.findAllCategory());
        ModelAndView mav = new ModelAndView("web/home");
        mav.addObject("category", category); 
        mav.addObject("newModel", news); 
        return mav;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView home2Page() {
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if( auth != null) {
        	new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ModelAndView("redirect:/home");
    }
    
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView deniedPage() {
        return new ModelAndView("redirect:/login?accessDenied");
    }
}
