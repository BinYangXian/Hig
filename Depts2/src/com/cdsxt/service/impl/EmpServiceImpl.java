package com.cdsxt.service.impl;

import java.util.List;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.dao.impl.EmpDaoImpl;
import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;
import com.cdsxt.vo.EmpVo;

public class EmpServiceImpl implements EmpService{

	private EmpDao empDao = new EmpDaoImpl();
	@Override
	public List<Emp> findByDeptno(Integer deptno) {
		return this.empDao.findByDeptno(deptno);
	}
	@Override
	public List<EmpVo> findEmpVoByDeptno(Integer deptno) {
		// TODO Auto-generated method stub
		return this.empDao.findEmpVoByDeptno(deptno);
	}

}
