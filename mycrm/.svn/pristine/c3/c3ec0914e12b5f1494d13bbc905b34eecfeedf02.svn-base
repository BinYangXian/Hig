package com.cdsxt.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.web.dao.StaffDao;
import com.cdsxt.web.po.Staff;

@Repository
public class StaffDaoImpl implements StaffDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//根据ID查找
	@Override
	public Staff findById(Integer id){
		return (Staff) this.getSession().get(Staff.class, id);
	}
	//分页查找
	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> findFroPage(int startRow,int pageRow){
		return this.getSession().createQuery("from Staff").setFirstResult(startRow).setMaxResults(pageRow).list();
	}
	//找到总条数
	@Override
	public long findCount(){
		return (long) this.getSession().createQuery("select count(s.id) from Staff s").uniqueResult();
	}
}
