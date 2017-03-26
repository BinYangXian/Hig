package com.cdsxt.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.RoleModuleDAO;
import com.cdsxt.po.RoleModule;

@Repository
public class RoleModuleDAOImpl implements RoleModuleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public RoleModule findByRoleIdAndModuleId(Integer roleId, Integer moduleId) {
		Query query = this.getSession().createQuery("from RoleModule rm where rm.role.id=:roleId and rm.module.id=:moduleId");
		query.setParameter("roleId", roleId);
		query.setParameter("moduleId", moduleId);
		return (RoleModule) query.uniqueResult();
	}

	@Override
	public void delete(RoleModule rm) {
		this.getSession().delete(rm);
	}

	@Override
	public void saveOrUpdate(RoleModule rm) {
		this.getSession().saveOrUpdate(rm);
	}
	
}
