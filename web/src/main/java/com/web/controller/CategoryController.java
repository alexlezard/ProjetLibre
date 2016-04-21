package com.web.controller;


import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.CategoryDao;
import com.web.model.Category;
import com.web.model.Response;
import com.web.model.Session;
import com.web.model.User;

@Controller
public class CategoryController extends MasterController{
	
	private static final String URL_GETUSERCATEGORIES 	= "/categories";
	private static final String URL_CATEGORY 		= "/categories";
	
	public CategoryController(){
		
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_GETUSERCATEGORIES, method = RequestMethod.GET)
	public @ResponseBody Response getCategories() {
		Response r 	= new Response();
		loader();
		
		if (isConnected) {
			User u = Session.getInstance().getUser();
			CategoryDao dao = new CategoryDao();
			u.setCategorieListJson(dao.getAll(getUserId()));
			r.setStatus("OK");
			r.setData(u.getCategorieListJson().toString());
			r.setMessage("list of categories");
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
	
	// exemple : {"name":"Boire"}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CATEGORY, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response createCategory(@RequestBody Category cat) {
		Response r 	= new Response();
		loader();
		
		if (cat!=null && cat.getName()!=null && userId>0) {
			CategoryDao dao = new CategoryDao();
			JSONArray jsonArr = dao.createDao(cat);;
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully inserted !");
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
	
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CATEGORY, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response updateCategory(@RequestBody Category cat) {
		Response r 	= new Response();
		loader();
		
		if (cat!=null && cat.getName()!=null && userId>0) {
			CategoryDao dao = new CategoryDao();
			JSONArray jsonArr = (JSONArray) dao.updateDao(cat);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("Category well updated");
			
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CATEGORY, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteCategory(@RequestBody Category cat) {
		Response r 	= new Response();
		loader();
		
		if (cat!=null && cat.getIdcategory()>0 && userId>0) {
			CategoryDao dao = new CategoryDao();
			JSONArray jsonArr = (JSONArray) dao.deleteDao(cat);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("Category well deleted");
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_GETUSERCATEGORIES+"/{idcategory}", method = RequestMethod.GET)
	public @ResponseBody Response getCategory(@PathVariable int idcategory) {
		Response r 	= new Response();
		loader();
		
		if (isConnected) {
			CategoryDao dao = new CategoryDao();
			r.setStatus("OK");
			r.setData(dao.findById(idcategory).toString());
			r.setMessage("category "+idcategory);
		} else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
}
