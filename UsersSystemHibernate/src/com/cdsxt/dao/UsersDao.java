package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Users;

public interface UsersDao {

	List<Users> findAll();

	Users findOne(int id);

	void update(Users users);

	void save(Users user);
	
	
}
