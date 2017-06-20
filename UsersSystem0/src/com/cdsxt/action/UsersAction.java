package com.cdsxt.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;
import com.cdsxt.service.impl.UsersServiceImpl;
import com.google.gson.Gson;

public class UsersAction {
	
	private UsersService usersService = new UsersServiceImpl();
	
	private List<Users> users;
	
	private Users user;
	
	private InputStream inputStream;
	
	public String findAll(){
		this.users = this.usersService.findAll();
		return "findAll";
	}
	
	public String save(){
		if(this.user!=null){
			this.usersService.save(user);
		}
		return "save-success";
		
	}
	
	public String findOne(){
		Integer id = null;
		if(this.user!=null){
			id = this.user.getId();
		}
		if(id!=null){
			this.user = this.usersService.findOne(id);
			String json = new Gson().toJson(this.user);
			if(json==null){
				json = "{}";
			}
			this.inputStream = new ByteArrayInputStream(json.getBytes());
			
		}
		return "stream-json";
	}
	public String findById(){
		Integer id = null;
		if(this.user!=null){
			id = this.user.getId();
		}
		if(id!=null){
			this.user = this.usersService.findOne(id);
		}
		return "json";
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

}
