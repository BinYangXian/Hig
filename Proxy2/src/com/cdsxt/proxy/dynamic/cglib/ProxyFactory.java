package com.cdsxt.proxy.dynamic.cglib;

import com.cdsxt.service.impl.UsersServiceImpl;

import net.sf.cglib.proxy.Enhancer;

public class ProxyFactory {
	//测试CGLIB动态代理
	//不管给定的目标类 是否有 实现接口 都可以进行代理
	
	public static UsersServiceImpl getLogProxy(UsersServiceImpl usersServiceImpl){
		//创建代理对象
		Enhancer enhancer = new Enhancer();
		//设置新建的代理类的超类
		//如果有实现相应的接口 可以设置 interface
		enhancer.setSuperclass(usersServiceImpl.getClass());
		
		enhancer.setCallback(new LogAdvice(usersServiceImpl));
		
		//创建真正的代理对象
		Object proxy = enhancer.create();
		
		return (UsersServiceImpl)proxy;
	}

}
