package com.web.controller;

import java.util.List;

import org.json.JSONArray;
import org.springframework.http.MediaType;
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
public class CategoryController extends MasterController{
	
	private static final String URL_GETUSERCATEGORIES 	= "/categories";
	private static final String URL_CATEGORY 		= "/category";
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
			
			//u.setCategorieList(dao.getAllCategories(userid));
			u.setCategorieListJson(dao.getAllCategories(userid));
			r.setStatus("OK");
			r.setData(u.getCategorieListJson().toString());
			r.setMessage("list of categories");
		} else {
			
			r.setStatus("KO");
			r.setMessage("Something went wrong !");
			r.setData(null);
		}
		return r;
	}
	
	// exemple : {"name":"Boire"}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CATEGORY, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response createCategory(@RequestBody Category cat) {
		Response r 	= new Response();
		int userId  = Session.getInstance().getUser().getId();
		
		if (cat!=null && cat.getName()!=null && userId>0) {
			CategoryDao dao = new CategoryDao();
			JSONArray jsonArr = (JSONArray) dao.create(cat);;
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully inserted !");
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CATEGORY, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response updateCategory(@RequestBody Category cat) {
		Response r 	= new Response();
		
		int userId = Session.getInstance().getUser().getId();
		
		if (cat!=null && cat.getName()!=null && userId>0) {
			CategoryDao dao = new CategoryDao();
			JSONArray jsonArr = (JSONArray) dao.updateCategory(cat);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("Category well updated");
			
		}else
			r.setMessage("KO");
		
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CATEGORY, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteCategory(@RequestBody Category cat) {
		Response r 	= new Response();
		int userId = (Session.getInstance()!=null && Session.getInstance().getUser()!=null)? Session.getInstance().getUser().getId():-1;
		
		if (cat!=null && cat.getIdcategory()>0 && userId>0) {
			CategoryDao dao = new CategoryDao();
			JSONArray jsonArr = (JSONArray) dao.deleteDao(cat);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("Category well deleted");
			
		}else
			r.setMessage("KO");
		
		
		return r;
	}
	
	
	
	
	
}
