package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdsxt.dao.DeptDao;
import com.cdsxt.po.Dept;
import com.cdsxt.utils.HibUtil;

public class DeptDaoImpl implements DeptDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> findAll() {
		Session session = HibUtil.getSession();
		Query query = session.createQuery("select d from Dept d");
		List<Dept> depts = query.list();
		return depts;
	}

}
