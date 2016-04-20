package com.web.dao;

import org.json.JSONArray;

import com.web.db.DbManager;
import com.web.model.Liste;
import com.web.model.Task;

public class TaskDao implements InterfaceDao{

	@Override
	public String findById(Object id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public JSONArray createDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlInsertTask((Task)obj);
		return null;
	}
	@Override
	public JSONArray deleteDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlDeleteTask((Task)obj);
		return null;
	}
	@Override
	public JSONArray updateDao(Object obj) {
		if (obj != null)
			return DbManager.getInstance().sqlUpdateTask( (Task)obj );
		return null;
	}
	@Override
	public JSONArray getAll(int id){
		if (id>=0){
			return DbManager.getInstance().sqlGetAllTasks(id);
		}
		return null;
	}

}
