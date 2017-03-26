package com.cdsxt.service.impl;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.dao.impl.UsersDaoImpl;
import com.cdsxt.service.UsersService;

public class UsersServiceImpl implements UsersService {

	private UsersDao usersDao = new UsersDaoImpl();
	
	@Override
	public void delete() {
		System.out.println("UsersServiceImpl.delete()");
		this.usersDao.delete();
	}

	@Override
	public void save() {
		System.out.println("调用了save方法");
		System.out.println("UsersServiceImpl.save()");
		this.usersDao.save();
	}

}
