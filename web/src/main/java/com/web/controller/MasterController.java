package com.web.controller;

import com.web.model.Response;
import com.web.model.Session;

public class MasterController {

	public MasterController(){
		boolean isConnected = (Session.getInstance().getUser()!=null)?true:false;
		Response r = new Response();
		if (!isConnected || Session.getInstance().getUser().getId()<=0){
			System.out.println( "You are not connected" );
		}else{
			System.out.println("You are connected");
		}
	}
	
	
	
}
