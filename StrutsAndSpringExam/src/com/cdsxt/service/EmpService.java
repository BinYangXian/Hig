package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Emp;

public interface EmpService {

	List<Emp> findAll();
	void addEmp(Emp e);
	void changeEmp(Emp e);
	Emp findEmpById(Integer empno);
	void delete(Integer empno);
}
