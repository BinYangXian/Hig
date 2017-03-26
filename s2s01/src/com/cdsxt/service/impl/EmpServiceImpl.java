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
	

}
