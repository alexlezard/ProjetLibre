package com.web.model;

import java.util.List;

import com.web.dao.InterfaceDao;

public class Liste{

	private String name;
	private String description;
	private List<Task> taskList;
	
	public Liste(){
		
	}
	
	
	/*******************************
	 ******* GETTER & SETTER *******
	 * *****************************/
	
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
