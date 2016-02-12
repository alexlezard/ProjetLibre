package com.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.model.User;


public class UserController{
	
	private static final String DOMAINE 		= "localhost:8080";
	private static final String URL_GETUSERINFO = DOMAINE+"/user";
	private static final String URL_GETLISTSUSER = DOMAINE+"/mylists"; 
		
	@RequestMapping(value = URL_GETUSERINFO, method = RequestMethod.GET)
	public @ResponseBody User getUserInformation() {
		User u = new User();
		u.setEmail("alex@gmail.com");
		u.setMdp("azerty87SJ");
		return u;
	}
	
	@RequestMapping(value = URL_GETLISTSUSER, method = RequestMethod.GET)
	public @ResponseBody User getMyLists() {
		return null;
	}
}
