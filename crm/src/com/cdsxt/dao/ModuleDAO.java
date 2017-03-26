package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Module;

public interface ModuleDAO {
	
	List<Module> findAll();

	Module findById(Integer moduleId);
	

}
