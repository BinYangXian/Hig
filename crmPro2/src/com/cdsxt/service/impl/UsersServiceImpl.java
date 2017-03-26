package com.cdsxt.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.RoleDao;
import com.cdsxt.dao.UsersDao;
import com.cdsxt.po.Role;
import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Override
	public Users findByUsername(String username) {
		return this.usersDao.findByUsername(username);
	}

	@Override
	public List<Users> findAll() {
		return this.usersDao.findAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateChooseRole(Integer id, Integer[] roleIds) {
		// TODO Auto-generated method stub
		//首先得到id所对应的用户
		Users users = this.usersDao.findById(id);
		if(users == null){
			return ;
		}
		
		Set<Role> roles = users.getRoles();
		//清空用户已有的角色
		if(roles==null){
			roles = Collections.emptySet();
		}
		
		roles.clear();
		
		//根据传入的ids去查询所有的角色
		//如果有  则重新建立联系
		//否则不管
		if(roleIds!=null && roleIds.length>0){
			//查询角色
			List<Role> rs = this.roleDao.findByIds(roleIds);
			roles.addAll(rs);
		}
		
		//更新回去
		
		this.usersDao.update(users);
	}

	@Override
	public Users findById(Integer id) {
		return this.usersDao.findById(id);
	}

}
