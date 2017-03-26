package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Role;

public interface RoleService {

	Role findById(Integer id);
	List<Role> findByIds(Integer[] ids);

	List<Role> findAll();
	void updateChooseMenu(Integer roleId, Integer[] menuIds);
	
	
}
