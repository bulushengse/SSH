package com.zhoubc.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.zhoubc.dao.IBaseDao;

@Repository("dao")
public class BaseDaoImpl implements IBaseDao{
	
	@Resource(name = "sessionFactory")
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf){
		this.sf = sf;
	}
	
	@Override
	public Object add(Object obj)  throws Exception{
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		session.save(obj);
		t.commit();
		return obj;
	}

	@Override
	public Object update(Object obj) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(obj);
			t.commit();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean delete(Object obj) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.delete(obj);
			t.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Object get(Class clzss, Serializable id) {
		Session session = sf.openSession();
		Object obj = session.get(clzss, id);
		session.close();
		return obj;
	}

	@Override
	public List<?> queryAll(Class clzss) {
		Session session = sf.openSession();
		List<?> list = session.createCriteria(clzss).list();
		session.close();
		return list;
	}

	@Override
	public List<?> queryAll(String hql) {
		Session session = sf.openSession();
		List<?> list = session.createQuery(hql).getResultList();
		session.close();
		return list;
	}

	@Override
	public List<?> querySQL(Class clzss, String sql) {
		Session session = sf.openSession();
		List<?> list = session.createNativeQuery(sql, clzss).list();
		session.close();
		return list;
	}

	@Override
	public List<?> queryPage(String hql, int page, int number) {
		Session session = sf.openSession();
		Query q = session.createQuery(hql);
		int first = (page - 1) * number;
		q.setFirstResult(first);
		q.setMaxResults(number);
		List<?> list = q.getResultList(); 
		return list;
	}

	
}
