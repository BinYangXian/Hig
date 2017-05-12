package com.cdhb.mange.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cdhb.mange.dao.UserDao;
import com.cdhb.mange.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
	UserDao userdao;
	@Override
	public void add() {
		userdao.add();
	}
	public UserDao getUserdao() {
		return userdao;
	}
	@Resource
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

}
