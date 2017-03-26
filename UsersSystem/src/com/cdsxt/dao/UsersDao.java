package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Emp;

public interface UsersDao {

	List<Emp> findAll();

	Emp findOne(int id);

	void update(Emp users);

	void save(Emp user);
	
	
}
