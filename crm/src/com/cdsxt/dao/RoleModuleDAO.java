package com.cdsxt.dao;

import com.cdsxt.po.RoleModule;

public interface RoleModuleDAO {

	
	RoleModule findByRoleIdAndModuleId(Integer roleId,Integer moduleId);
	
	void delete(RoleModule rm);
	
	void saveOrUpdate(RoleModule rm);
	
}
