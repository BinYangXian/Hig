package com.cdsxt.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.RoleDAO;
import com.cdsxt.dao.UsersDAO;
import com.cdsxt.po.Role;
import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;
import com.cdsxt.vo.RoleVo;

@Service
@Transactional(readOnly=true)
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersDAO usersDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public Users findByUsername(String username) {
		return this.usersDAO.findByUsername(username);
	}

	@Override
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return this.usersDAO.findAll();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateChooseRole(Integer id, Integer[] roleIds) {
		// TODO Auto-generated method stub
		//建立联系
		Users users = this.usersDAO.findById(id);
		if(users==null){
			return ;
		}
		
		Set<Role> roles = users.getRoles();
		
		if(roles==null){
			roles = new HashSet<Role>();
		}
		
		if(!roles.isEmpty()){
			roles.clear();
		}
		
		if(roleIds!=null && roleIds.length>0){
			List<Role> rs = this.roleDAO.findByIds(roleIds);
			roles.addAll(rs);
		}
		
		this.usersDAO.update(users);
	}

	@Override
	public List<RoleVo> findAllRoleInUsersToJson(Integer id) {
		List<RoleVo> vos = new ArrayList<RoleVo>();
		Users users = this.usersDAO.findById(id);
		if(users!=null){
			Set<Role> roles = users.getRoles();
			if(roles!=null && !roles.isEmpty()){
				for(Role role:roles){
					vos.add(new RoleVo(role));
				}
			}
		}
		return vos;
	}

}
