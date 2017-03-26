package com.cdsxt.dao;

import com.cdsxt.po.RoleModule;

public interface RoleModuleDao {

	RoleModule findByRoleIdAndModuleId(Integer roleId,Integer moduleId);
	
	void saveOrUpdate(RoleModule rm);
	
	void delete(RoleModule rm);
}
