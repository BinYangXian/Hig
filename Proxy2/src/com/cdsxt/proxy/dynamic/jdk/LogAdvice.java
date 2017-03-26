package com.cdsxt.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogAdvice implements InvocationHandler {

	/**
	 * 第一个参数  是 代理对象   不能直接打印  会内存溢出
	 * 第二个参数  正在被调用的目标了方法对象
	 * 第三个参数  调用的方法的参数
	 * 
	 * 返回值：  应该返回 被调用方法的返回值
	 * 
	 * 
	 */
	
	private Object target;
	
	public LogAdvice(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println(proxy.getClass());
		System.out.println(method.getName());
		System.out.println(method.getDeclaringClass());
		System.out.println(method.getReturnType());
		System.out.println("正在调用 "+method.getDeclaringClass().getSimpleName()+"的"+method.getName()+"方法");
		System.out.println(args);
		//执行方法
		Object value = method.invoke(target, args);
		return value;
	}

}
