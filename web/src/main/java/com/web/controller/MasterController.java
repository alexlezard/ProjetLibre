package com.web.controller;

import com.web.model.Response;
import com.web.model.Session;
import com.web.model.User;

public class MasterController {
	
	boolean isConnected = false;
	int userId  = -1;
	User user = null;
	
	public MasterController(){

//		if (Session.getInstance().getUser()!=null && Session.getInstance().getUser().getId()>0){
//			userId = Session.getInstance().getUser().getId();
//			isConnected = true;
//		}else{
//			System.out.println("You are not connected");
//			isConnected = false;
//		}	
	}

	public Response getResponseNotConnected(boolean isconnected) {
		Response r = new Response();
		
		if (!isconnected){
			r.setStatus("SESSION-EXPIRED");
			r.setMessage(null);
			r.setData(null);
		} else{
			r.setStatus("KO");
			r.setMessage("Something went wrong !");
			r.setData(null);
		}
		return r;
	}
	
	public void loader(){
		User user = (Session.getInstance().getUser()!=null)?Session.getInstance().getUser():null;
		userId = (Session.getInstance().getUser()!=null && (Session.getInstance().getUser().getId()>0)?Session.getInstance().getUser().getId():-1);
		if (userId > 0)
			isConnected = true;
		else {
			isConnected = false;
		}
	}
	
	
	/***********************************
	 **********  GETTER & SETTER  ******
	 ***********************************/

	public boolean isConnected() {
		return isConnected;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
