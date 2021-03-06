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

@Controller
public class ListeController extends MasterController{
	
	private static final String URL_LIST	= "/lists";
	private static final String URL_LISTS	= "categories/{idcategory}/lists";
	
	public ListeController(){
		
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LIST, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response createlist(@RequestBody Liste lst) {
		Response r 	= new Response();
		loader();
		
		if (lst!=null && lst.getName()!=null && isConnected) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.createDao(lst);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new list has been successfully inserted !");
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LISTS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response getAllList(@PathVariable int idcategory) {
		Response r 	= new Response();
		loader();
		
		if (idcategory>=0 && isConnected) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.getAll(idcategory);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("You Got all List of task from category : "+idcategory);
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LIST, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response updatelist(@RequestBody Liste lst) {
		Response r 	= new Response();
		loader();
		
		if (lst!=null && lst.getName()!=null && isConnected) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.updateDao(lst);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new list has been successfully updated !");
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LIST, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deletelist(@RequestBody Liste lst) {
		Response r 	= new Response();
		loader();
		
		if (lst!=null && lst.getName()!=null && lst.getIdlist()>0 && isConnected) {
			ListeDao dao = new ListeDao();
			JSONArray jsonArr = (JSONArray) dao.deleteDao(lst);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new list has been successfully deleted !");
		}else if (!isConnected) {
			return getResponseNotConnected(isConnected);
		}
		return r;
	}
}
