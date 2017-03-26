package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Emp;

public interface JdbcEmpDao {

	List<Emp> findAll();

	Emp findByEmpno(Integer empno);
	
	void save(Emp emp);
	void update(Emp emp);
}
