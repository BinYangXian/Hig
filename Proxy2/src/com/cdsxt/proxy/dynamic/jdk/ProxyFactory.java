package com.cdsxt.proxy.dynamic.jdk;

import java.lang.reflect.Proxy;

import com.cdsxt.service.UsersService;

public class ProxyFactory {
	
	//JDK 动态代理   所代理的类  必须实现接口
	public static UsersService getLogProxy(UsersService usersService){
		//第一个参数  是类加载器
		//第二个参数  代理目标类实现的接口数组
		//得三个参数  方法增强
		return (UsersService)Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), new Class[]{UsersService.class},new LogAdvice(usersService));
	}

}
