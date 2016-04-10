package com.web.model;

import java.util.List;

public class Category {
	
	private int id;
	private String name;
	private int idUser; 
	
	private List<Liste> listofList;
	
	public Category(){
		if(User.getInstance()!=null) 
			setIdUser(User.getInstance().getId());
		else
			setIdUser(-1);
		
	}
	
	/*********************
	 ** GETTER & SETTER ** 
	 * *******************/
	public int getId() 				 { return id; }
	public void setId(int id) 		 { this.id = id; }
	public String getName() 		 { return name; }
	public void setName(String name) { this.name = name; }
	public int getIdUser() 		 	 { return idUser; }
	public void setIdUser(int id) 	 { this.idUser = id;}
}
