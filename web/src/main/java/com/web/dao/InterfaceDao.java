package com.web.dao;

public interface InterfaceDao {
	
	public String insert(Object obj);
	
	public String remove(Object obj);
	
	public String update(Object obj);
	
	public Object findById(Object obj);
}
