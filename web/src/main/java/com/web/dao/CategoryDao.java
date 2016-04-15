package com.web.dao;

import java.util.List;

import org.json.JSONArray;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mysql.jdbc.StringUtils;
import com.web.db.DbManager;
import com.web.model.Category;
import com.web.model.Response;

public class CategoryDao implements InterfaceDao {
	
	@Override
	public Object findById(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(Object obj) {
		return null;
	}
	
	public JSONArray create(Object obj) {
		return DbManager.getInstance().InsertCategory( (Category) obj );
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
	
	public Object updateCategory(Object obj) {
		return DbManager.getInstance().UpdateCategory( (Category) obj );
	}
	
	public JSONArray getAllCategories(int id){
		if (id>0){
			return DbManager.getInstance().getAllUserCategories();
		}
		return null;
	}
	
	

}
