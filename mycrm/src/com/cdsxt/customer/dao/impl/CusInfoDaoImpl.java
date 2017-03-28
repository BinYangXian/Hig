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
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public List<CrmCustomer> findAllCustomer() {
		Query query = this.getSession().createQuery("from CrmCustomer c");
		return query.list();
	}

	@Override
	public void addCustomer(CrmCustomer c) {
		this.getSession().save(c);		
	}

	@Override
	public void deleCustomer(Integer i) {
		CrmCustomer c = (CrmCustomer) this.getSession().get(CrmCustomer.class, i);
		if(c!=null){
			this.getSession().delete(c);
		}
	}

	@Override
	public void updateCustomer(Integer cusId, CrmCustomer crmCustomer) {
		CrmCustomer c = (CrmCustomer) this.getSession().get(CrmCustomer.class, cusId);
		if(c!=null){
			this.getSession().update(crmCustomer);
		}
	}
	@Override
	public List<String> findAllCrmCusAreaNames() {
		Query query = this.getSession().createQuery("select c.areaName from CrmCusArea c");
		return query.list();
	}
	@Override
	public List<String> findAllLevelName() {
		Query query = this.getSession().createQuery("select c.levelName from CrmCusLevel c");
		return query.list();
	}
	@Override
	public List<String> findAllLinkmanNames() {
		Query query = this.getSession().createQuery("select c.linkmanName from CusLinkman c");
		return query.list();
	}

}
