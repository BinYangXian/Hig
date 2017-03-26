package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.ModuleDao;
import com.cdsxt.po.Module;

@Repository
public class ModuleDaoImpl implements ModuleDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Module> findAll() {
		Query query = this.getSession().createQuery("from Module m");
		return query.list();
	}

	@Override
	public Module findById(Integer moduleId) {
		return (Module) this.getSession().get(Module.class, moduleId);
	}

}
