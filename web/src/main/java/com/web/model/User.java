package com.web.model;

import java.util.List;

public class User {
	
	private static User user;
	
	private int id;
	private String userName;
	private String email;
	private String password;
	private String token;
	private boolean isConnected = true;
	
	private List<Category> categorieList;
	
	public User(){
		
	}
	
	public static synchronized User getInstance( ) {
		      if (user == null)
		          user =new User();
		      return user;
	}
	
	/*********************
	 ** GETTER & SETTER ** 
	 * *******************/
	
	public String getEmail() 					{ return email; }
	public void setEmail(String email) 			{ this.email = email; } 	
	public String getPassword() 				{ return password; }
	public void setPassword(String password) 	{ this.password = password; }
	public int getId() 							{ return id; }
	public void setId(int id) 					{ this.id = id; }
	public String getUserName() 				{ return userName; }
	public void setUserName(String userName) 	{ this.userName = userName; }
	public String getToken() 					{ return token; }
	public void setToken(String token) 			{ this.token = token; }
	public boolean isConnected() 				{ return isConnected; }
	public void setConnected(boolean value) 	{ this.isConnected = value; }
}
