package com.web.model;

public class User {

	private String email;
	private String mdp;
	
	public User(){
		
	}
	
	
	/*********************
	 ** GETTER & SETTER ** 
	 * *******************/
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email;}
	
	public String getMdp() { return mdp;}
	public void setMdp(String mdp) { this.mdp = mdp; }

}
