package com.cdsxt.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdsxt.service.UsersService;

@Controller
public class UsersAction {

	@Autowired
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
