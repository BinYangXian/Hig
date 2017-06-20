package com.cdsxt.service;

import java.util.List;
import java.util.Map;

import com.cdsxt.po.Menu;
import com.cdsxt.po.Role;
import com.cdsxt.vo.RoleVo;

public interface RoleService {

	List<Role> findAll();

	List<Menu> findMenuInRole(Integer id);

	void updateChooseMenu(Integer id, Integer[] menuIds);

	List<RoleVo> findAllToVo();

	Map<Integer, Integer> findPowersByRoleId(Integer id);
	
	
	
}
