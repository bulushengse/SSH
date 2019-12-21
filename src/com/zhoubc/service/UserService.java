package com.zhoubc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhoubc.bean.User;

@Service("userService")
public class UserService extends BaseService{
	
	
	public void addUser(User user) throws Exception{
		dao.add(user);
	}
	
	/**
	 * 登录判断
	 * @param user
	 * @throws Exception
	 */
	public User getUserByNameAndPwd(String USERNAME,String PASSWORD) throws Exception{
		String hql = "from User  user where user.USERNAME='"+USERNAME+"' and user.PASSWORD='"+PASSWORD+"'";
		List<User> list = (List<User>) dao.queryAll(hql);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
}
