package com.cdsxt.customer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.customer.dao.CusInfoDao;
import com.cdsxt.customer.po.CrmCustomer;
@Repository
public class CusInfoDaoImpl implements CusInfoDao{
	@Autowired
	private SessionFactory sessionFactory;
	private Session currentSession = this.sessionFactory.getCurrentSession();
	@Override
	public List<CrmCustomer> findAllCustomer() {
		Query query = currentSession.createQuery("from CrmCustomer c");
		return query.list();
	}

	@Override
	public void addCustomer(CrmCustomer c) {
		currentSession.save(c);		
	}

	@Override
	public void deleCustomer(Integer i) {
		currentSession.createQuery("select c from CrmCustomer c where c.cusId=:i")
		currentSession.delete(arg0);
		
	}

	@Override
	public void updateCustomer(Integer cusId, CrmCustomer crmCustomer) {
		// TODO Auto-generated method stub
		
	}

}
