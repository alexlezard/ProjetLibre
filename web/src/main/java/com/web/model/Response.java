package com.web.model;

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
