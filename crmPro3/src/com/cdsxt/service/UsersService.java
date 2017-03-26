package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Users;

public interface UsersService {

	Users findByUsername(String username);

	List<Users> findAll();
	Users findById(Integer id);

	void updateChooseRole(Integer id, Integer[] roleIds);
	
	
}
