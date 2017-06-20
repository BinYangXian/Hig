package com.cdsxt.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cdsxt.service.UsersService;

// 在ioc中的名称   就是  类名的第一个字符小写后的名称
@Controller("ua")
public class UsersAction {

	@Resource(name="b")
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
	
	public String getPassword(){
		return "abcd";
	}

}
