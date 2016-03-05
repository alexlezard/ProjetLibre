package com.web.model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.controller.UserController;
import com.web.dao.UserDao;
import com.web.helper.CommonHelper;

public class Response {
	
	public String status;
	public String message;
	public Object data;
	
	public Response(){
		
	}
	
	
	
	/*******************************
	 ******* GETTER & SETTER *******
	 * *****************************/
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object obj) {
		this.data = obj;
	}

	
}
