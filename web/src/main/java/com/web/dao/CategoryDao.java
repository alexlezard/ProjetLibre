package com.web.dao;

import java.util.List;

import com.mysql.jdbc.StringUtils;
import com.web.db.DbManager;
import com.web.model.Category;

public class CategoryDao implements InterfaceDao {

	@Override
	public Object findById(Object obj) {
		// TODO Auto-generated method stub
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
	
	public List getAllCategories(int id){
		if (id>0){
			return DbManager.getInstance().getAllUserCategory(id);
		}
		return null;
	}
	
	

}
