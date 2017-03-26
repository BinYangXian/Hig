package com.cdsxt.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;

@Controller
@Scope("prototype")
public class UsersAction {
	@Autowired
	private UsersService usersService;
	
	private Users users;

	public void findAll(){
		System.out.println("UsersAction.findAll()");
	}
	
	public void save(){
		this.usersService.save(users);
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
