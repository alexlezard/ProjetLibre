package com.web.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.dao.UserDao;
import com.web.db.DbManager;
import com.web.helper.CommonHelper;
import com.web.model.Response;
import com.web.model.Session;
import com.web.model.User;

@Controller
public class UserController extends MasterController{
	
	private static final String URL_GETUSERINFO 	= "/user";
	private static final String URL_CREATEUSER 		= "/users";
	private static final String URL_REMOVEUSER 		= "/users";
	private static final String URL_LOGIN 			= "/login";
	
	public UserController() {
			
	}
	
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
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_LOGIN, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Response login(@RequestBody User userBody) {
		Response r 	 = new Response();
		String email =  userBody.getEmail();
		
		if (CommonHelper.emailValidator(email) && userBody!=null) {
				UserDao ud 	= new UserDao();
				User user 	= (User) ud.findById(email);
				Session.getInstance().setUser(user);
				
				System.out.println(" pwd request "+userBody.getPassword());
				System.out.println(" pwd bdd "+user.getPassword());
				System.out.println(" pwd bdd "+user.getId());
				
				if (CommonHelper.toSha1(userBody.getPassword()).equals(user.getPassword())) {
					r.setStatus("OK");
					r.setMessage("User has been connected sucessfully");
					user.setConnected(true);
					user.setPassword("*********************");
					r.setData(user);
					
					return r;
				}
				
				r.setStatus("KO");
				r.setMessage("Id's are not correct :-(");
				r.setData(null);
				
				return r;
		}
		
		r.setStatus("KO");
		r.setMessage("Id's are not correct");
		r.setData(null);
		
		return r;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = URL_CREATEUSER, method = RequestMethod.POST)
	public @ResponseBody Response createUser(@RequestBody User userBody) {
		Response r 	= new Response();
		
		if (CommonHelper.emailValidator(userBody.getEmail())) {
			UserDao ud 	= new UserDao();
			boolean isInserted = ud.insert(userBody);
			
			if (isInserted) {
				r.setStatus("OK");
				r.setData(null);
				r.setMessage("You have been registred successfully. Welcome ! ");
				return r;
			}
		}
		
		r.setStatus("KO");
		r.setData(null);
		r.setMessage("Some fields you wrote down went wrong. Try again !");
		
		return r;
	}
	
	@RequestMapping(value = URL_REMOVEUSER, method = RequestMethod.DELETE)
	public @ResponseBody User removeUser() {
		return null;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String displayHelloWorld(){
		return "Welcome";
	}
}
