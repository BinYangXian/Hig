package com.cdsxt.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class ScopeAction {
	
	public String test1(){
		//得到request对象  Map<String,Object>
//		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
//		request.put("aaaa", "bbbbb");
//		Map<String,Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
//		session.put("aaaa", "bbbbb");
		Map<String,Object> application = (Map<String, Object>) ActionContext.getContext().getApplication();
		application.put("aaaa", "bbbbb");
		
		
		return "test1";
	}
	
	public void test2(){
		//得到request对象  Map<String,Object>
//		Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
//		System.out.println(request.get("aaaa"));
		Map<String,Object> application = (Map<String, Object>) ActionContext.getContext().getApplication();
		System.out.println(application.get("aaaa"));
	}

}
