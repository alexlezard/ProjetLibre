package com.web.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.web.db.DbManager;
import com.web.model.User;

public class UserDao implements InterfaceDao{
	
	public UserDao(){
		
	}
	
	@Override
	public String insert() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean insert(User userBody) {
		return DbManager.getInstance().InsertUser(userBody);
	}

	@Override
	public String remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(String email) {
		if (email instanceof String){
				try { 
					return DbManager.getInstance().selectRecordsFromTable(email);
				} catch (SQLException e) { e.printStackTrace();};
		}
		return null;
	}
	
	public String login(){
		return null;
	}
	
	public String logout(){
		return null;
	}

	@Override
	public String findById(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}


}
