package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Emp;

public interface EmpDao {

	List<Emp> findAll();

	void addEmp(Emp e);

	void changeEmp(Emp e);

	Emp findEmpById(Integer empno);

	void delete(Integer empno);
}
