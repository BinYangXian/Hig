package com.cdsxt.service.impl;

import java.util.List;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.dao.impl.UsersDaoImpl;
import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;

public class UsersServiceImpl implements UsersService{
	
	
	private UsersDao usersDao = new UsersDaoImpl();

	@Override
	public List<Users> findAll() {
		return this.usersDao.findAll();
	}

	@Override
	public Users findOne(int id) {
		return this.usersDao.findOne(id);
	}

	@Override
	public void update(Users users) {
		// TODO Auto-generated method stub
		this.usersDao.update(users);
	}

	@Override
	public void save(Users user) {
		// TODO Auto-generated method stub
		this.usersDao.save(user);
	}

}
