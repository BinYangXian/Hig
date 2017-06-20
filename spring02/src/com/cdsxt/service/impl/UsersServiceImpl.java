package com.cdsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.service.UsersService;

@Service("a")
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersDao usersDao;
	
	@Override
	public void delete() {
		System.out.println("UsersServiceImpl.delete()++++++++++++++++++++++++++++");
		this.usersDao.delete();
	}

	@Override
	public void save() {
		System.out.println("UsersServiceImpl.save()");
		this.usersDao.save();
	}

	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
}
