package com.web.dao;

import org.json.JSONArray;

import com.web.db.DbManager;
import com.web.model.Category;
import com.web.model.Liste;

public class ListeDao implements InterfaceDao{

	@Override
	public String findById(Object id) {
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
	
	public JSONArray createDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlInsertList((Liste) obj);
		return null;
	}
	
	public JSONArray deleteDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlDeleteList((Liste) obj);
		return null;
	}
	
	public Object updateDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlUpdateList( (Liste) obj );
		return null;
	}
	
	public JSONArray getAllListe(int id){
		if (id>0){
			return DbManager.getInstance().sqlGetAllList(id);
		}
		return null;
	}

}
