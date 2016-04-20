package com.web.dao;

import org.json.JSONArray;

import com.web.db.DbManager;
import com.web.model.Task;

public interface InterfaceDao {
	
	public Object findById(Object obj);
	
	public JSONArray createDao(Object obj);
	
	public JSONArray deleteDao(Object obj);
	
	public JSONArray updateDao(Object obj);
	
	public JSONArray getAll(int id);
}
