package com.zhoubc.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhoubc.bean.User;
import com.zhoubc.service.UserService;

@Controller("loginAction")
@Scope("prototype")//struts2 是要求每次访问都对应不同的Action,所以scope="prototype",当有请求的时候都会创建一个新的Action对象 
public class LoginAction extends BaseAction{
	private String USERNAME;
	private String PASSWORD;
	
	private Map<String,Object> resultMap = new HashMap<String,Object>();
	
	@Resource(name = "userService")
	private UserService userService;
	
	/**
	 * 去登录页面
	 */
	public String goLogin(){
		
		return "goLogin";
	}
	
	/**
	 * 登录验证
	 */
	public String checkLogin() throws Exception{
		log(logger,"用户登录验证："+USERNAME);
		User user = userService.getUserByNameAndPwd(USERNAME, PASSWORD);
		if(user != null) {
			session.put("USERNAME", USERNAME);
			session.put("USER", user);
			resultMap.put("retCode", "1");
			resultMap.put("	retMsg", "登录成功");
			log(logger,"用户："+USERNAME+",登录成功！");
		}else {
			resultMap.put("retCode", "0");
			resultMap.put("	retMsg", "登录失败");
			log(logger,"用户："+USERNAME+",登录失败！");
		}
		return SUCCESS;
	}

	
	/**
	 * 访问主页
	 */
	public String main_Index(){
		USERNAME=(String) session.get("USERNAME");
		
		return "main_Index";
	}
	
	
	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public Map<String, Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
}
