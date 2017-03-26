package com.cdsxt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;
import com.cdsxt.vo.EmpVo;

public class EmpDaoImpl implements EmpDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> findByDeptno(Integer deptno) {
		Session session = HibUtil.getSession();
		Query query = session.createQuery("select e from Emp e where e.dept.deptno=?");
		query.setInteger(0, deptno);
		List<Emp> emps = query.list();
		return emps;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpVo> findEmpVoByDeptno(Integer deptno) {
		List<EmpVo> vos = new ArrayList<>();
		Session session = HibUtil.getSession();
		Query query = session.createQuery("select e from Emp e where e.dept.deptno=?");
		query.setInteger(0, deptno);
		List<Emp> emps = query.list();
		for(Emp emp:emps){
			vos.add(new EmpVo(emp));
		}
		return vos;
	}

}
