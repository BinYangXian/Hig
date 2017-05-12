package com.cdhb.mange.dao.ipl;

import org.springframework.stereotype.Repository;

import com.cdhb.mange.dao.UserDao;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	public void add(){
	System.out.println("添加一个用户");
	}

}
