package com.cdsxt.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PowerInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 1494460577908667148L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//没有实现功能  只是通过它
		invocation.invoke();
		return null;
	}

}
