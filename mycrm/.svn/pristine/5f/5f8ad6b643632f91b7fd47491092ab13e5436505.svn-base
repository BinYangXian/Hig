package com.cdsxt.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.web.dao.RoleDao;
import com.cdsxt.web.dao.UserDao;
import com.cdsxt.web.po.Role;
import com.cdsxt.web.po.User;
import com.cdsxt.web.service.UserService;
import com.cdsxt.web.util.MD5keyBean;
import com.cdsxt.web.vo.RoleVo;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAll() {
		return this.userDao.findAll();
	}

	@Override
	public User findByUserName(String userName) {
		return this.userDao.findByUserName(userName);
	}

	// 修改密码
	@Override
	@Transactional(readOnly = false)
	public void updatePwd(User user, String newPwd) {

		newPwd = new MD5keyBean().getkeyBeanofStr(newPwd);
		user.setPassword(newPwd);
		userDao.updateUser(user);
	}

	// 保存用户
	@Transactional(readOnly = false)
	@Override
	public void addRole(User user) {
		userDao.addUser(user);
	}

	// 分页查找
	@Override
	public List<User> findForPage(int startPage, int rowPage) {
		return this.userDao.findForPage(startPage, rowPage);

	}

	@Override
	public int findCount() {
		return (int) (long) this.userDao.findCount();
	}

	// 根据Id查找
	@Override
	public User findById(Integer userId) {
		return this.userDao.findById(userId);
	}

	// 修改用户
	@Override
	@Transactional(readOnly=false)
	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}
	//删除用户
	@Override
	@Transactional(readOnly=false)
	public void deleteUser(User user){
		this.userDao.deleteUser(user);
	}

}
