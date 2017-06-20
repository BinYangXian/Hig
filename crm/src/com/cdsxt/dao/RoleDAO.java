package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Role;
import com.cdsxt.vo.RoleVo;

public interface RoleDAO {

	List<Role> findAll();
	
	List<Role> findByIds(Integer []ids);
	Role findById(Integer id);

	void update(Role role);

	List<RoleVo> findAllToVo();
}
