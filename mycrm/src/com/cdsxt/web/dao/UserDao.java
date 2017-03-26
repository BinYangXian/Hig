package com.cdsxt.web.dao;

import java.util.List;

import com.cdsxt.web.po.User;

public interface UserDao {

	List<User> findAll();

	User findByUserName(String userName);

	User findById(Integer id);

	void updateUser(User user);

	List<User> findAll(int startRow, int pageRow);

	void addUser(User user);

	List<User> findForPage(int startPage, int rowPage);

	Long findCount();

	void deleteUser(User user);
	
	
}
