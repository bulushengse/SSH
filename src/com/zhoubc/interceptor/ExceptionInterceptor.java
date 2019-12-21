package com.zhoubc.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.zhoubc.util.Logger;

public class ExceptionInterceptor implements Interceptor{

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
		logger.info("---------------------------------------------------------检测程序异常拦截器");
	 	String result = "";
        try {
            result = arg0.invoke();
        } catch (Exception e) {
        	logger.info("---------------------------------------------------------程序出现异常！！！！！");
        	e.printStackTrace();
        	return "error";
        }
	    return result;
	}
	
}
