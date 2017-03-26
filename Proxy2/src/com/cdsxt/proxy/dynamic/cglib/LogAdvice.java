package com.cdsxt.proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogAdvice implements MethodInterceptor{

	private Object target;
	
	public LogAdvice(Object target){
		this.target = target;
	}
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy arg3) throws Throwable {
		System.out.println("测试CGLIB");
		System.out.println(proxy.getClass());
		System.out.println(method.getName());
		System.out.println(method.getDeclaringClass());
		System.out.println(method.getReturnType());
		System.out.println("正在调用 "+method.getDeclaringClass().getSimpleName()+"的"+method.getName()+"方法");
		System.out.println(args);
		
		Object value = method.invoke(target, args);
		
		return value;
	}

}
