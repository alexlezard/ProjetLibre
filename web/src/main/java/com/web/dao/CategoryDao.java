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
		return null;
	}
	
	@Override
	public JSONArray createDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlInsertCategory( (Category) obj );
		return null;
	}
	
	@Override
	public JSONArray deleteDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlDeleteCategory( (Category) obj );
		return null;
	}
	
	@Override
	public JSONArray updateDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlUpdateCategory( (Category) obj );
		return null;
	}

	@Override
	public JSONArray getAll(int id) {
		if (id>0)
			return DbManager.getInstance().getAllUserCategories(-1);
		return null;
	}
	
	public JSONArray findById(int id) {
		if (id>0)
			return DbManager.getInstance().sqlGetCategory(id);
		return null;
	}
}
