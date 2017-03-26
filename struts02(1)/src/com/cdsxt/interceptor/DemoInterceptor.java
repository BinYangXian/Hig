package com.cdsxt.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 *
 * 实现拦截器的步骤
 * 
 * 实现Interceptor
 * 
 * 继承AbstractInterceptor 类
 */
public class DemoInterceptor extends AbstractInterceptor{
	private static final long serialVersionUID = -5936880294336713030L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		/**
		 * 拦截方法
		 * 
		 * 如果  返回null这  不会有  结果对应
		 * 
		 * 如果返回字符串 一定会去  找result结果
		 * 
		 * 
		 * 
		 */
		//正在执行的action对象
		Object action = invocation.getAction();
		//得到代理类
		ActionProxy proxy = invocation.getProxy();
		
		String actionName = proxy.getActionName();
		
		String method = proxy.getMethod();
		
		String namespace = proxy.getNamespace();
		
		Result result = invocation.getResult();
		//得到执行结果
		String code = invocation.getResultCode();
		
		System.out.println(action);
		System.out.println(actionName);
		System.out.println(method);
		System.out.println(namespace);
		System.out.println(code);
		//通过
		invocation.invoke();
		
		
		
		return null;
	}

}
