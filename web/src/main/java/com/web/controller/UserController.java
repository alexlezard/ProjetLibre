package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.model.User;

@Controller
public class UserController{
	
	private static final String URL_GETUSERINFO 	= "/user";
	private static final String URL_GETLISTSUSER 	= "/mylists"; 
	private static final String URL_CREATEUSER 		= "/createUser";
	private static final String URL_REMOVEUSER 		= "/removeUser";
	private static final String URL_LOGIN 		= "/login";
	
	@RequestMapping(value = URL_GETUSERINFO, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getUserInformation(String email) {
		User u = new User();
		u.setEmail("alex@gmail.com");
		u.setMdp("azerty87SJ");
		
		return u;
	}
	
	// recuperer json depuis le client : {email:"toto@toto.com",mdp:"azeert123"}
	// renvoyer JSON avec nom , email, id  
	// en option : avec un token, date d'expiration du token
	@RequestMapping(value = URL_LOGIN, method = RequestMethod.POST)
	public @ResponseBody User Login() {
		return null;
	}
	
	@RequestMapping(value = URL_CREATEUSER, method = RequestMethod.POST)
	public @ResponseBody User createUser() {
		return null;
	}
	
	@RequestMapping(value = URL_REMOVEUSER, method = RequestMethod.POST)
	public @ResponseBody User removeUser() {
		return null;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String displayHelloWorld(){
		return "Hello Pakpak !!";
	}
}
