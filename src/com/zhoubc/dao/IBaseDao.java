package com.zhoubc.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {

	public Object add(Object obj) throws Exception;

	public Object update(Object obj) throws Exception;

	public boolean delete(Object obj) throws Exception;

	public Object get(Class clzss, Serializable si) throws Exception;

	public List<?> queryAll(Class clzss) throws Exception;

	public List<?> queryAll(String hql) throws Exception;

	public List<?> querySQL(Class clzss, String sql) throws Exception;

	public List<?> queryPage(String hql, int page, int number) throws Exception;
	
}
