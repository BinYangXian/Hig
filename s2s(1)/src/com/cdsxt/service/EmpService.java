package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Emp;

public interface EmpService {

	List<Emp> findAll();

	Emp findByEmpno(Integer empno);
	
	void save(Emp emp);
	void update(Emp emp);
}
