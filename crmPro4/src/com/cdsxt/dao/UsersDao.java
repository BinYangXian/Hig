package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Users;

public interface UsersDao {

	Users findByUsername(String username);
	
	Users findById(Integer id);

	List<Users> findAll();

	void update(Users users);
	
}

