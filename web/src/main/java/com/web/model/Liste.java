package com.web.model;

import java.util.List;

import com.web.dao.InterfaceDao;

public class Liste{

	private int idlist;
	private String name;
	private String description;
	private int category_idcategory;
	
	private List<Task> taskList;
	
	public Liste(){
		
	}
	
	/*******************************
	 ******* GETTER & SETTER *******
	 * *****************************/
	public int getIdlist() {
		return idlist;
	}
	public void setIdlist(int idlist) {
		this.idlist = idlist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Task> getTaskList() {
		return taskList;
	}
	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}
	public int getCategory_idcategory() {
		return category_idcategory;
	}
	public void setCategory_idcategory(int category_idcategory) {
		this.category_idcategory = category_idcategory;
	}
}
