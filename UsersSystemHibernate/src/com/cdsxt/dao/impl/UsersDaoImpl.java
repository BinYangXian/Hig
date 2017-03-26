package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.po.Users;
import com.cdsxt.utils.HibUtil;

public class UsersDaoImpl implements UsersDao {

	@Override
	public List<Users> findAll() {
		Session session = HibUtil.getSession();
		Query query = session.createQuery("select u from Users u");
		List<Users> users = query.list();
		session.close();
		return users;
	}

	@Override
	public Users findOne(int id) {
		Session session = HibUtil.getSession();
		Users users = (Users) session.get(Users.class, id);
		session.close();
		return users;
	}

	@Override
	public void update(Users users) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.update(users);
		tx.commit();
		session.close();
	}

	@Override
	public void save(Users user) {
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

}
