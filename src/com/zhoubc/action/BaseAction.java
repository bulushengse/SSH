package com.zhoubc.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.zhoubc.util.Logger;
import com.zhoubc.util.UuidUtil;

@Controller
@Scope("prototype")
public class BaseAction extends ActionSupport implements ServletRequestAware, ServletResponseAware, SessionAware, ServletContextAware{
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;
	protected Map session;
	
	protected Logger logger = Logger.getLogger(this.getClass());
	
	private static final String STR1 = "===>";
	
	private static final String STR2 = "=============start=================";
	
	@Override
	public void setServletContext(ServletContext arg0) {
		this.application = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
	public static void logBefore(Logger logger, String interfaceName) {
		logger.info("");
		logger.info(STR1+interfaceName+STR2);
	}
	
	public static void log(Logger logger, String str) {
		logger.info(STR1+str);
	}

	public static void logAfter(Logger logger) {
		logger.info("===>end");
		logger.info("");
	}
	
	/**
	 * 得到32位的uuid
	 * @return
	 */
	public String get32UUID() {

		return UuidUtil.get32UUID();
	}
	
	/**
	 * 获取登录用户名  
	 * @return
	 */
	protected String getUNAME() {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("USERNAME");
		return username;
	}
	
	
	/*	public Object getBean(String name){
			BeanFactory bf = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
			if(bf.containsBean(name)){
				return bf.getBean(name);
			}
			return null;
		} */

}
