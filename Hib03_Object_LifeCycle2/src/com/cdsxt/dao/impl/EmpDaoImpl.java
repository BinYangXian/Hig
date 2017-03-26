package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;

public class EmpDaoImpl implements EmpDao{

	@Override
	public List<Emp> findAll() {
		Session session = HibUtil.getSession();
		//HQL
		Query query = session.createQuery("select e from Emp e");
		List<Emp> emps = query.list();
		session.close();
		return emps;
	}

	@Override
	public Emp findByEmpno(Integer empno) {
		Session session = HibUtil.getSession();
		Emp emp = (Emp) session.get(Emp.class, empno);
		session.close();
		return emp;
	}

	@Override
	public void delete(Integer empno) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Object object = session.get(Emp.class, empno);
		session.delete(object);
		tx.commit();
		session.close();
		
	}

	@Override
	public void save(Emp emp) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(emp);
		tx.commit();
		session.close();
		
	}

	@Override
	public void update(Emp emp) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(emp);
		tx.commit();
		session.close();
	}

	@Override
	public void saveOrUpdate(Emp emp) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(emp);
		tx.commit();
		session.close();
	}

}
