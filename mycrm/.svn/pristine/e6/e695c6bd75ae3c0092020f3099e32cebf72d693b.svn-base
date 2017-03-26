package com.cdsxt.web.service;

import java.util.List;

import com.cdsxt.web.po.User;

public interface UserService {

	List<User> findAll();

	User findByUserName(String userName);

	void updatePwd(User user, String newPwd);

	void addRole(User user);

	List<User> findForPage(int startPage, int rowPage);

	int findCount();

	User findById(Integer userId);

	void updateUser(User user);

	void deleteUser(User user);
	
}
