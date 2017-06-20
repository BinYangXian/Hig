package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Role;

public interface RoleDao {

	Role findById(Integer id);
	List<Role> findByIds(Integer[] ids);

	List<Role> findAll();
	
}
