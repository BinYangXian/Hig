package com.cdsxt.intercepter;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PowerInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 549057070763037504L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//得到执行的路径    然后根据当前角色所有拥有的模块  的权限码  来判断  该请求是否有权限
		//路径应该是有  namespace+actionName
		//得到powerCode列表   我一定要知道  该路径所指定powercode是多少
		//在当前session中一定有一个路径和powercode之间的映射关系
		
		
		//用于得到 路径  方法  action
		ActionProxy proxy = invocation.getProxy();
		
		String actionName = proxy.getActionName();
		if("loginAction".equals(actionName)){
			invocation.invoke();
			return null;
		}
		
		//得到路径  namespace+actionName
		String uri = this.getUri(proxy);
		//得到  方法名
		String methodName = proxy.getMethod();
		
		
		//得到Session中的PowerCode
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		Map<String,Integer> powers = (Map<String, Integer>) session.get("powers");
		
		//得到Session中已经存在的PowerCode
		Integer powerCode = powers.get(uri);
		
		if(powerCode==null){
			return "nopower";
		}
		
		if(methodName.startsWith("find")){
			//有查询权限
			if((powerCode&1)==1){
				invocation.invoke();
				return null;
			}
		}else if(methodName.startsWith("delete")){
			//有查询权限
			if((powerCode&8)==8){
				invocation.invoke();
				return null;
			}
			
		}else if(methodName.startsWith("update")){
			//有查询权限
			if((powerCode&4)==4){
				invocation.invoke();
				return null;
			}
			
		}else if(methodName.startsWith("add")){
			//有查询权限
			if((powerCode&2)==2){
				invocation.invoke();
				return null;
			}
			
		}
		return "nopower";
	}
	
	private String getUri(ActionProxy proxy){
		String namespace = proxy.getNamespace();
		String actionName = proxy.getActionName();
		if(StringUtils.hasLength(namespace)){
			namespace = namespace.substring(1)+"/";
		}
		return namespace+actionName;
		
	}

}
