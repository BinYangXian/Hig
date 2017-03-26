package com.cdsxt.sell.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.sell.dao.SalesOppDao;
import com.cdsxt.sell.po.SalesOpp;

@Controller
@Scope("prototype")
public class SalesOppDaoImpl implements SalesOppDao{
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//找到全部销售机会
	@SuppressWarnings("unchecked")
	@Override
	public List<SalesOpp> findAll(){
		return this.getSession().createQuery("from SalesOpp").list();
	}
	//通过ID查找
	@Override
	public SalesOpp findById(Integer id){
		return (SalesOpp) this.getSession().get(SalesOpp.class, 1);
	}

	
}
