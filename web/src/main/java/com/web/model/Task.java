package com.web.model;


public class Task{
	
	private int idtask;
	private String name;
	private String description;
	private int list_idlist;

	public Task(){
		
	}
	
	/*******************************
	 ******* GETTER & SETTER *******
	 * *****************************/
	public int getIdtask() {
		return idtask;
	}
	public void setIdtask(int idtask) {
		this.idtask = idtask;
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
	public int getList_idlist() {
		return list_idlist;
	}
	public void setList_idlist(int list_idlist) {
		this.list_idlist = list_idlist;
	}
}
