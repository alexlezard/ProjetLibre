package com.web.dao;

import java.sql.SQLException;

import org.json.JSONArray;

import com.web.db.DbManager;
import com.web.model.User;

public class UserDao implements InterfaceDao{
	
	public boolean insert(User userBody) {
		if (userBody !=null)
			return DbManager.getInstance().InsertUser(userBody);
		return false;
	}

	@Override
	public Object findById(Object email) {
		if ((String)email instanceof String){
			try { 
				return DbManager.getInstance().getUser((String)email);
			} catch (SQLException e) { e.printStackTrace();};
		}
		return null;
	}

	@Override
	public JSONArray createDao(Object obj) {
		return null;
	}

	@Override
	public JSONArray deleteDao(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray updateDao(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray getAll(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
