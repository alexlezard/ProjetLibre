package com.web.controller;

import com.web.model.Session;

public class MasterController {
	
	boolean isConnected = false;

	public MasterController(){

		if (Session.getInstance().getUser()!=null && Session.getInstance().getUser().getId()>0){
			System.out.println( "You are connected" );
			isConnected = true;
		}else{
			System.out.println("You are not connected");
			isConnected = false;
		}
		
	}
	
	/***********************************
	 **********  GETTER & SETTER  ******
	 ***********************************/

	public boolean isConnected() {
		return isConnected;
	}

}
