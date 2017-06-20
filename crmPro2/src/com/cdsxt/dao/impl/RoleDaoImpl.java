package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.RoleDao;
import com.cdsxt.po.Role;

@Repository
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public Role findById(Integer id) {
		return (Role) this.getSession().get(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByIds(Integer[] ids) {
		Query query = this.getSession().createQuery("from Role r where r.roleId in (:ids)");
		query.setParameterList("ids", ids);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		Query query = this.getSession().createQuery("from Role r");
		return query.list();
	}

}
