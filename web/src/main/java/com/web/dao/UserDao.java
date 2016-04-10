package com.web.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.web.db.DbManager;
import com.web.model.User;

public class UserDao implements InterfaceDao{
	
	public UserDao() {
		
	}
	
	public boolean insert(User userBody) {
		return DbManager.getInstance().InsertUser(userBody);
	}
//	public User findById(Object email) {
//		if ((String)email instanceof String){
//				try { 
//					return DbManager.getInstance().getUserFromTable(email);
//				} catch (SQLException e) { e.printStackTrace();};
//		}
//		return null;
//	}
	
	public String login(){
		return null;
	}
	
	public String logout(){
		return null;
	}

	@Override
	public Object findById(Object email) {
		if ((String)email instanceof String){
			try { 
				return (User)DbManager.getInstance().getUser((String)email);
			} catch (SQLException e) { e.printStackTrace();};
		}
		return null;
	}

	@Override
	public String insert(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}


}
