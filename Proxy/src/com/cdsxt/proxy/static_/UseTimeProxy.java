package com.cdsxt.proxy.static_;

import com.cdsxt.service.UsersService;

public class UseTimeProxy implements UsersService {

	private UsersService usersService;
	
	public UseTimeProxy(UsersService usersService){
		this.usersService = usersService;
	}
	
	
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		this.usersService.delete();
		long end = System.currentTimeMillis();
		System.out.println("花费了"+(end-start)+"ms");
	}

	@Override
	public void save() {
		long start = System.currentTimeMillis();
		this.usersService.save();
		long end = System.currentTimeMillis();
		System.out.println("花费了"+(end-start)+"ms");
	}

}
