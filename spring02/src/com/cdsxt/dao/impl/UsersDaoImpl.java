package com.cdsxt.dao.impl;

import org.springframework.stereotype.Repository;

import com.cdsxt.base.impl.BaseDaoImpl;
import com.cdsxt.dao.UsersDao;

@Repository
public class UsersDaoImpl extends BaseDaoImpl implements UsersDao {

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
