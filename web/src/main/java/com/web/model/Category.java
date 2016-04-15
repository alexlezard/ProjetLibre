package com.web.model;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

public class Category {
	
	private int idcategory;
	private String name;
	private int user_iduser; 

	private List<Liste> listofList;
	
	public Category(){
		
	}
	
	/*********************
	 ** GETTER & SETTER ** 
	 * *******************/
	public String getName() 		 			{ return name; }
	public void setName(String name) 			{ this.name = name; }
	public int getUser_iduser() 	 			{ return user_iduser;}
	public void setUser_iduser(int user_iduser) { this.user_iduser = user_iduser;}
	public int getIdcategory() 					{ return idcategory;}
	public void setIdcategory(int idcategory) 	{ this.idcategory = idcategory;}
	
	@Override
	public String toString() {
		return "Category [idcategory=" + idcategory + ", name=" + name + ", user_iduser=" + user_iduser
				+ ", listofList=" + listofList + "]";
	}
	
	public JSONObject toJSONObject(){
		JSONObject obj = new JSONObject();
		try {
			obj.put("idcategory", getIdcategory());
			obj.put("idcategory", getName());
		} catch (JSONException e) { e.printStackTrace(); }
		
		return obj;
		
	}
}
