package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.dao.JdbcEmpDao;
import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDao empDao;
	
	@Autowired
	private JdbcEmpDao jdbcEmpDao;
	
	@Override
	public List<Emp> findAll() {
		return this.jdbcEmpDao.findAll();
	}

	@Override
	public Emp findByEmpno(Integer empno) {
		// TODO Auto-generated method stub
		return this.jdbcEmpDao.findByEmpno(empno);
	}

	@Override
	public void save(Emp emp) {
		// TODO Auto-generated method stub
		this.jdbcEmpDao.save(emp);
	}
	
	@Override
	public void update(Emp emp) {
		this.jdbcEmpDao.update(emp);
	}
	

}
