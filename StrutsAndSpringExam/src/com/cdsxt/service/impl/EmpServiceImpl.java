package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Emp> findAll() {
		return this.empDao.findAll();
	}

	@Override
	public void addEmp(Emp e) {
		this.empDao.addEmp(e);
	}

	@Override
	public void changeEmp(Emp e) {
		this.empDao.changeEmp(e);
	}

	@Override
	public Emp findEmpById(Integer empno) {
		return this.empDao.findEmpById(empno);
	}

	@Override
	public void delete(Integer empno) {
		this.empDao.delete(empno);
	}
	

}
