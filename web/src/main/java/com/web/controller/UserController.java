package com.web.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.UserDao;
import com.web.db.DbManager;
import com.web.helper.CommonHelper;
import com.web.model.Response;
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
		u.setPassword("azerty87SJ");
		
		return u;
	}
	
	// recuperer json depuis le client : {email:"toto@toto.com",mdp:"azeert123"}
	// renvoyer JSON avec nom , email, id  
	// en option : avec un token, date d'expiration du token
	@RequestMapping(value = URL_LOGIN, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response Login(@RequestBody User userBody) {
		Response r 	= new Response();
		String email =  userBody.getEmail();
		
		if (CommonHelper.emailValidator(email)) {
			if (userBody!=null) {
				UserDao ud 	= new UserDao();
				User user 	= ud.findById(email);
				
				r.setStatus("OK");
				r.setMessage("User has been connected sucessfully");
				r.setData(user);
				
				return r;
			}
		}
		
		r.setStatus("KO");
		r.setMessage("Email is not correct");
		r.setData(null);
		
		return r;
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
