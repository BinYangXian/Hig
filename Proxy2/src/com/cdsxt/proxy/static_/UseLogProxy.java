package com.cdsxt.proxy.static_;

import com.cdsxt.service.UsersService;

public class UseLogProxy implements UsersService {
	
	private UsersService usersService;
	
	public UseLogProxy(UsersService usersService){
		this.usersService = usersService;
	}

	@Override
	public void delete() {
		this.usersService.delete();
	}

	@Override
	public void save() {
		System.out.println("调用了方法");
		this.usersService.save();
	}

}
