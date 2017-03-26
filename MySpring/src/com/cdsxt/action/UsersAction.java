package com.cdsxt.action;

import com.cdsxt.service.UsersService;

public class UsersAction {

	private UsersService usersService;
	
	public void save(){
		System.out.println("UsersAction.save()");
		this.usersService.save();
	}
	
	public void delete(){
		System.out.println("UsersAction.delete()");
		this.usersService.delete();
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

}
