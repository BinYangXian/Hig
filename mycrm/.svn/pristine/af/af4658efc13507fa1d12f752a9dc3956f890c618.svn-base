package com.cdsxt.web.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.web.dao.RoleModuleDao;
import com.cdsxt.web.po.RoleModule;

@Repository
public class RoleModuleDaoImpl implements RoleModuleDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public void deleteRoleModule(RoleModule roleModule){
		this.getSession().delete(roleModule);
	}
	
	@Override
	public RoleModule findById(Integer id){
		return (RoleModule) this.getSession().get(RoleModule.class, id);
	}
}
