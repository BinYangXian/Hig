package com.cdsxt.dao.impl;

import com.cdsxt.dao.UsersDao;

public class UsersDaoImpl implements UsersDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UsersDaoImpl.save()");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("UsersDaoImpl.delete()");
	}

}
