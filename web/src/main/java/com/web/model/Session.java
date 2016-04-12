package com.web.model;

public class Session {
	
	private static Session session;
	
	User user;
	Category category;

	public static synchronized Session getInstance( ) {
	    if (session == null)
	    	session =new Session();
	    return session;
	}
	
	/*********************
	 ** GETTER & SETTER ** 
	 * *******************/
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
