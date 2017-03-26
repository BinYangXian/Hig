package com.cdsxt.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.web.dao.ModuleDao;
import com.cdsxt.web.po.Module;

@Repository
public class ModuleDaoImpl implements ModuleDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//找到全部的功能块
	@SuppressWarnings("unchecked")
	@Override
	public List<Module> findAll(){
		return this.getSession().createQuery("from Module").list();
	}
	
	//根据ID查找
	@Override
	public Module findById(Integer moduleId){
		return (Module) this.getSession().get(Module.class, moduleId);
	}
	
}
