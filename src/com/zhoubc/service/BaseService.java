package com.zhoubc.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhoubc.bean.Page;
import com.zhoubc.dao.impl.BaseDaoImpl;
import com.zhoubc.util.StringUtil;

@Service("baseService")
public class BaseService {
	
	@Resource(name = "dao")
	public BaseDaoImpl dao;
	
	public List<?> queryPage(Page page,String hql){
		//查询条件
		Map<String, String> paramMap = page.getParam();
		if(paramMap !=null && paramMap.size()>0) {
			hql +=" where 1=1";
			Iterator<Entry<String, String>> it = page.getParam().entrySet().iterator();
			while(it.hasNext()){
	             Entry<String, String> entry = it.next();
	             if(!StringUtil.isEmpty(entry.getValue())) {
	            	 hql += " and "+entry.getKey()+"='"+entry.getValue()+"'";
	     		 }
	         }
		}
		//排序
		Map<String, String> sortMap = page.getSort();
		String sortField = sortMap.get("sortField");
		String sortMethod = sortMap.get("sortMethod");
		if(!StringUtil.isEmpty(sortField) && !StringUtil.isEmpty(sortMethod)) {
			hql +=" order by "+sortField+" "+sortMethod;
		}
		
		System.out.println("hql:"+hql);
		List<?> listAll = dao.queryAll(hql);
		page.setTotalResult(listAll.size());
		List<?> list = dao.queryPage(hql, page.getCurrentPage(), page.getShowCount());
		return list;
	}
	
}
