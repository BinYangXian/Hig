package com.cdsxt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.ModuleDAO;
import com.cdsxt.dao.RoleDAO;
import com.cdsxt.dao.RoleModuleDAO;
import com.cdsxt.po.RoleModule;
import com.cdsxt.service.RoleModuleService;

@Service
@Transactional(readOnly=true)
public class RoleModuleServiceImpl implements RoleModuleService {
	
	@Autowired
	private RoleModuleDAO roleModuleDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private ModuleDAO moduleDAO;

	@Transactional(propagation= Propagation.REQUIRED)
	@Override
	public void updateModulePowerCode(Integer id, Integer moduleId, Integer powerCode) {
		
		/**
		 * 根据roleid和moduleid去查询中间表记录
		 * 
		 * 如果返回没有记录  则添加新记录
		 * 
		 * 否则  判断权限
		 * 
		 * 	判断是添加权限或者是减去权限
		 * 
		 * 	如果是减去权限  则判断是否为最后一个权限  如果是  则删除记录   
		 * 
		 * 
		 */
		
		RoleModule rm = this.roleModuleDAO.findByRoleIdAndModuleId(id, moduleId);
		
		if(rm==null){
			//没有记录  新增即可
			rm = new RoleModule();
			rm.setPowerCode(powerCode);
			rm.setRole(this.roleDAO.findById(id));
			rm.setModule(this.moduleDAO.findById(moduleId));
		}else{
			//有记录
			if((rm.getPowerCode()&powerCode)==powerCode){
				//则表示已经包含了该权限  应该减去权限
				if((rm.getPowerCode()^powerCode)==0){
					//判断是否为最后一个权限
					this.roleModuleDAO.delete(rm);
					return ;
				}else{
					rm.setPowerCode(rm.getPowerCode()^powerCode);
				}
				
			}else{
				//加权限
				rm.setPowerCode(rm.getPowerCode()|powerCode);
			}
			
		}
		
		this.roleModuleDAO.saveOrUpdate(rm);
	}

}
