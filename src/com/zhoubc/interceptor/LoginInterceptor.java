package com.zhoubc.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.zhoubc.util.Logger;
import com.zhoubc.util.StringUtil;

public class LoginInterceptor implements Interceptor{

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		logger.info("---------------------------------------------------------用户是否登录判断拦截器");
		
		//获取request对象
		ActionContext actionContext = arg0.getInvocationContext(); 
		HttpServletRequest request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		String path = request.getServletPath();
		//登录用户判断
		if(!"/login_toLogin.do".equals(path) && !"/checkLogin.action".equals(path)) {
			String USERNAME=(String) arg0.getInvocationContext().getSession().get("USERNAME");
			logger.info("----"+USERNAME);
			if(StringUtil.isEmpty(USERNAME)) {
				return "noLogin";
			}
		}
		return arg0.invoke();
	}

}
