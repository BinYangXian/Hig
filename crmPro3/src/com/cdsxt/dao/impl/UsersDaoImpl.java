package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.po.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	//根据传入的用户名去查询用户
	@Override
	public Users findByUsername(String username) {
		Query query = this.getSession().createQuery("from Users u where u.username=:username");
		query.setParameter("username", username);
		return (Users) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> findAll() {
		Query query = this.getSession().createQuery("from Users u");
		return query.list();
	}

	@Override
	public Users findById(Integer id) {
		return (Users) this.getSession().get(Users.class, id);
	}

	@Override
	public void update(Users users) {
		this.getSession().update(users);
	}

}
