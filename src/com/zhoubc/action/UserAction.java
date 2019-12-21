package com.zhoubc.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.zhoubc.bean.Page;
import com.zhoubc.bean.User;
import com.zhoubc.service.UserService;


@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction{
	private User user;
	
	private String USERNAME;
	
	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	private String message;
	
	private Page page;

	private List<User> userList;
	
	private InputStream inputStream;
	
	@Resource(name = "userService")
	private UserService userService;
	
	
	/**
	 * 去新增用户页面
	 */
	public String goAdd(){
		
		return "goAdd";
	}
	
	/**
	 * 新增用户
	 */
	public String add() throws  Exception{
		log(logger,"用户："+getUNAME()+",请求新增用户");
		user.setUSER_ID(this.get32UUID());// ID
		userService.addUser(user);
		message ="1";
		return "addUser";
	}

	/**
	 * 去用户查询页面
	 */
	public String goQueryPage(){
		
		return "goQueryPage";
	}
	/**
	 * 分页查询
	 */
	public String queryPage() throws  Exception{
		log(logger,"用户："+getUNAME()+",请求分页查询用户");
		if(page ==null) {
			page = new Page();
		}
		String hql = "from User user";
		userList = (List<User>) userService.queryPage(page,hql);
		
		return "queryPageUser";
	}
	
	
	/**
	 *  下载
	 */
	public String download() throws  Exception{
	
		inputStream  = new ByteArrayInputStream("Struts2 文件下载测试".getBytes());   
		
		return SUCCESS;
	}
        
    //对于配置中的 ${fileName}, 获得下载保存时的文件名        
    public String getFileName() {        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");        
        String fileName = "日期(" + df.format(new Date()) + ").txt";  
		try {        
		    //中文文件名也是需要转码为UTF-8，否则乱码        
		       return new String(fileName.getBytes(), "UTF-8"); 
		} catch (UnsupportedEncodingException e) {        
		    return "impossible.txt";        
		}      
    }    
    
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
}
