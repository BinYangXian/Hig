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

}
