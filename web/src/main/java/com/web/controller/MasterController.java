package com.web.controller;

import org.springframework.stereotype.Controller;

import com.web.dao.CategoryDao;
import com.web.model.Response;
import com.web.model.Session;
import com.web.model.User;

@Controller
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
