package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Users;

public interface UsersDAO {
	
	Users findByUsername(String username);

	List<Users> findAll();
	
	Users findById(Integer id);
	
	void update(Users users);
}
