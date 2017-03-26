package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Emp;

public interface UsersService {

	
	List<Emp> findAll();

	Emp findOne(int id);

	void update(Emp users);

	void save(Emp user);
	
	
	
}
