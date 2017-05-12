package com.cdsxt.action;

import com.cdsxt.proxy.dynamic.cglib.ProxyFactory;
import com.cdsxt.proxy.static_.UseLogProxy;
import com.cdsxt.proxy.static_.UseTimeProxy;
import com.cdsxt.service.UsersService;
import com.cdsxt.service.impl.UsersServiceImpl;

public class UsersAction {

//	private UsersService usersSerivce = new UseTimeProxy(new UseLogProxy(new UsersServiceImpl()));//jdk代理
	private UsersService usersSerivce = ProxyFactory.getLogProxy(new UsersServiceImpl());//cglib代理
	
	public void save(){
		System.out.println("UsersAction.save()");
		this.usersSerivce.save();
	}
	
	public void delete(){
		System.out.println("UsersAction.delete()");
		this.usersSerivce.delete();
	}


	
	
}
