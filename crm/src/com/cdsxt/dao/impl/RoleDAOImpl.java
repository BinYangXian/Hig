package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.RoleDAO;
import com.cdsxt.po.Role;
import com.cdsxt.vo.RoleVo;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() {
		Query query = this.getSession().createQuery("from Role u");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findByIds(Integer[] ids) {
		Query query = this.getSession().createQuery("from Role r where r.id in (:ids)");
		query.setParameterList("ids", ids);
		return query.list();
	}

	@Override
	public Role findById(Integer id) {
		return (Role) this.getSession().get(Role.class,id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		this.getSession().update(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RoleVo> findAllToVo() {
		Query query = this.getSession().createQuery("select new com.cdsxt.vo.RoleVo(r.id,r.name) from Role r");
		return query.list();
	}
}
