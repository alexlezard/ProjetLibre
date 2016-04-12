package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.CategoryDao;
import com.web.dao.UserDao;
import com.web.helper.CommonHelper;
import com.web.model.Category;
import com.web.model.Response;
import com.web.model.Session;
import com.web.model.User;

@Controller
public class CategoryController {
	
	private static final String URL_GETUSERCATEGORIES 	= "/categories";
	private static final String URL_GETLISTS 		= "/categories/{categoryId}/lists";
	private static final String URL_GETTASKS 		= "/lists/{listId}/tasks";
	
	public CategoryController(){
	
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_GETUSERCATEGORIES, method = RequestMethod.GET)
	public @ResponseBody Response getCategories() {
		Response r 	= new Response();
		User u = Session.getInstance().getUser();
		int userid 	= u.getId();
		
		System.out.println( " userid "+userid);
		if (userid>0) {
			CategoryDao dao = new CategoryDao();
			
			u.setCategorieList(dao.getAllCategories(userid));
			
			r.setStatus("OK");
			r.setData(u.getCategorieList());
			r.setMessage("list of categories");
		} else {
			
			r.setStatus("KO");
			r.setMessage("Something went wrong !");
			r.setData(null);
		}
		return r;
	}
	
}
