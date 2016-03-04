package com.web.model;

public class User {

	private int id;
	private String userName;
	private String email;
	private String password; 

	public User(){
		
	}
	
	/*********************
	 ** GETTER & SETTER ** 
	 * *******************/
	
	public String getEmail() 					{ return email; }
	public void setEmail(String email) 			{ this.email = email;}	
	public String getPassword() 				{ return password; }
	public void setPassword(String password) 	{ this.password = password; }
	public int getId() 							{ return id; }
	public void setId(int id) 					{ this.id = id; }
	public String getUserName() 				{ return userName;}
	public void setUserName(String userName) 	{ this.userName = userName; }
	
}
