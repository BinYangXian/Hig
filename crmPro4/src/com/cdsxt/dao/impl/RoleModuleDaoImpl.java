package com.cdsxt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.RoleModuleDao;
import com.cdsxt.po.RoleModule;

@Repository
public class RoleModuleDaoImpl implements RoleModuleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public RoleModule findByRoleIdAndModuleId(Integer roleId, Integer moduleId) {
		Query query  =this.getSession().createQuery("from RoleModule rm where rm.role.roleId=:roleId and rm.module.moduleId=:moduleId");
		query.setInteger("roleId", roleId);
		query.setInteger("moduleId", moduleId);
		return (RoleModule) query.uniqueResult();
	}

	@Override
	public void saveOrUpdate(RoleModule rm) {
		this.getSession().saveOrUpdate(rm);
	}
	
	@Override
	public void delete(RoleModule rm) {
		this.getSession().delete(rm);
	}
	
	
}
