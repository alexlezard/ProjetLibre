package com.web.controller;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.TaskDao;
import com.web.model.Response;
import com.web.model.Task;

@Controller
public class TaskController extends MasterController{
	
	private static final String URL_TASK		= "/task";
	private static final String URL_GETTASKS 	= "/lists/{idlist}/tasks";
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_TASK, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response createTask(@RequestBody Task task) {
		Response r 	= new Response();
		
		if (task!=null && task.getName()!=null) {
			TaskDao dao = new TaskDao();
			JSONArray jsonArr = (JSONArray) dao.createDao(task);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new task has been successfully inserted !");
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_GETTASKS, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Response getAllTasks(@PathVariable int idlist) {
		Response r 	= new Response();
		
		if (idlist>=0) {
			TaskDao dao = new TaskDao();
			JSONArray jsonArr = (JSONArray) dao.getAll(idlist);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("You Got all task of list : "+idlist);
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_TASK, method = RequestMethod.PUT, produces = "application/json")
	public @ResponseBody Response updateTask(@RequestBody Task task) {
		Response r 	= new Response();
		
		if (task!=null && task.getName()!=null) {
			TaskDao dao = new TaskDao();
			JSONArray jsonArr = (JSONArray) dao.updateDao(task);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully updated !");
		}else
			r.setMessage("KO");
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_TASK, method = RequestMethod.DELETE, produces = "application/json")
	public @ResponseBody Response deleteTask(@RequestBody Task task) {
		Response r 	= new Response();
		
		if (task!=null && task.getName()!=null && task.getIdtask()>=0) {
			TaskDao dao = new TaskDao();
			JSONArray jsonArr = (JSONArray) dao.deleteDao(task);
			r.setStatus("OK");
			r.setData(jsonArr.toString());
			r.setMessage("A new category has been successfully updated !");
		}else
			r.setMessage("KO");
		
		return r;
	}
}
