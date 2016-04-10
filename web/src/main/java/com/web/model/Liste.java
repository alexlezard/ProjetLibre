package com.web.model;

import java.util.List;

import com.web.dao.InterfaceDao;

public class Liste{

	private int id;
	private String name;
	private String description;
	private int idCatedory;
	
	private List<Task> taskList;
	
	public Liste(){
		
	}
	
	
	/*******************************
	 ******* GETTER & SETTER *******
	 * *****************************/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCatedory() {
		return idCatedory;
	}
	public void setIdCatedory(int idCatedory) {
		this.idCatedory = idCatedory;
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
}
