package com.cdsxt.web.service;

import java.util.List;
import java.util.Map;

import com.cdsxt.web.po.Role;
import com.cdsxt.web.vo.ModuleVo;
import com.cdsxt.web.vo.RoleVo;

public interface RoleService {

	Role findById(Integer roleId);

	List<Role> findAllRole();

	Role findByName(String name);

	void updateOrAddRole(Role role, Integer[] menuIds);

	void deleteRole(Role role);

	List<ModuleVo> findRoleModule(Role role);

	void updateRoleModule(Integer roleId, String moduleJsons);

	Map<String, Integer> RolePowercodeUrl(Role role);

	long findAllCount();

	List<Role> findForPage(int startRow, int pageRow);

	List<RoleVo> findAllRoleVo();



	

}
