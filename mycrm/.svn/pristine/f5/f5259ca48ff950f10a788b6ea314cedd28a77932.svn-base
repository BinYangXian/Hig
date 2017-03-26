package com.cdsxt.web.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PowerInterceptor extends AbstractInterceptor{

	
	private static final long serialVersionUID = 1L;
	List<String> urls=new ArrayList<String>();
	@Override
	public void init() {
		super.init();
		urls.add("menuAction_findAll");
		urls.add("roleAction_findRoleModule");
		urls.add("userAction_getRoleVo");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy=invocation.getProxy();
		String nameSpace=proxy.getNamespace().substring(1);
		String actionName="";
		String vali="";
		String methodName=proxy.getMethod();
		if ("!".indexOf(proxy.getActionName())!=-1) {
			actionName=proxy.getActionName().split("!")[0];
		}else {
			actionName=proxy.getActionName().split("_")[0];
			vali=actionName+"_"+methodName;
		}
		if(actionName.equals("loginAction")){
			invocation.invoke();
			return null;
		}

		@SuppressWarnings("unchecked")
		Map<String, Integer> power=(Map<String, Integer>) ActionContext.getContext().getSession().get("roleMap");
		String url=nameSpace+"/"+actionName;
		
		if(power==null){
			return "nopower";
		}
		for (String x : urls) {
			if(x.equals(vali)){
				invocation.invoke();
//				System.out.println("特殊权限："+x);
				return null;
			}
		}

		Integer powerCode=power.get(url);
		if(powerCode==null){
			return "nopower";
		}

		if(methodName.startsWith("add")&&((powerCode&1)==1)){
			invocation.invoke();
			return null;
		}else if(methodName.startsWith("delete")&&((powerCode&2)==2)){
			invocation.invoke();
			return null;
		}else if (methodName.startsWith("update")&&((powerCode&4)==4)) {
			invocation.invoke();
			return null;
		}else if (methodName.startsWith("find")&&((powerCode&8)==8)) {
			invocation.invoke();
			return null;
		}else {
			return "nopower";
		}
	}
}
