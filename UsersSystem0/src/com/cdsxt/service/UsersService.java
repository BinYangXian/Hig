package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Users;

public interface UsersService {

	
	List<Users> findAll();

	Users findOne(int id);

	void update(Users users);

	void save(Users user);
	
	
	
}
