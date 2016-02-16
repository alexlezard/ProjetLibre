package com.web.model;

import java.util.List;

public class Task{
	
	private String name;
	private String description;
	
	public Task(){
		
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


}
