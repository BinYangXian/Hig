package com.cdsxt.service.serviceImp;

import java.util.List;

import com.cdsxt.dao.DeptDao;
import com.cdsxt.dao.impl.DeptDaoImpl;
import com.cdsxt.po.Dept;
import com.cdsxt.service.DeptService;

public class DeptServiceImpl implements DeptService {

	private DeptDao deptDao = new DeptDaoImpl();
	
	@Override
	public List<Dept> findAll() {
		// TODO Auto-generated method stub
		return this.deptDao.findAll();
	}

}
