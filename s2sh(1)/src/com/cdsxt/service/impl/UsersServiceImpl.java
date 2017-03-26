package com.cdsxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	
	@Autowired
	private UsersDao usersDao;
	
	@Override
	public void save(Users users) {
		this.usersDao.save(users);
	}

}
