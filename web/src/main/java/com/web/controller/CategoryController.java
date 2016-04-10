package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.UserDao;
import com.web.helper.CommonHelper;
import com.web.model.Response;
import com.web.model.User;

@Controller
public class CategoryController {
	
	private static final String URL_GETCATEGORIES 	= "/categories";
	private static final String URL_GETLISTS 		= "/categories/{categoryId}/lists";
	private static final String URL_GETTASKS 		= "/lists/{listId}/tasks";
	
	public CategoryController(){
		
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_GETCATEGORIES, method = RequestMethod.GET)
	public @ResponseBody Response getCategories() {
		Response r 	= new Response();
		
		return r;
	}
	
}
