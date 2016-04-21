package com.web.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.ListeDao;
import com.web.model.Liste;
import com.web.model.Response;
import com.web.model.Session;

@Controller
public class ListeController extends MasterController{
	
	private static final String URL_LIST	= "/list";
	private static final String URL_LISTS	= "category/{idcategory}/lists";
	
	public ListeController(){
		System.out.println("ListeController");
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LIST, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response createlist(@RequestBody Liste lst) {
		Response r 	= new Response();
		int userId  = Session.getInstance().getUser().getId();
		
		if (lst!=null && lst.getName()!=null && userId>0) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.createDao(lst);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully inserted !");
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LISTS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response getAllList(@PathVariable int idcategory) {
		Response r 	= new Response();
		int userId  = Session.getInstance().getUser().getId();
		
		if (idcategory>=0 && userId>=0) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.getAll(idcategory);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("You Got all List of task from category : "+idcategory);
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LIST, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response updatelist(@RequestBody Liste lst) {
		Response r 	= new Response();
		int userId  = Session.getInstance().getUser().getId();
		
		if (lst!=null && lst.getName()!=null && userId>0) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.updateDao(lst);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully updated !");
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LIST, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deletelist(@RequestBody Liste lst) {
		Response r 	= new Response();
		int userId  = Session.getInstance().getUser().getId();
		
		if (lst!=null && lst.getName()!=null && lst.getIdlist()>0 && userId>0) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.deleteDao(lst);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully updated !");
		}else
			r.setMessage("KO");
		
		return r;
	}
}
