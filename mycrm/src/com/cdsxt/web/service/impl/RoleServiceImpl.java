package com.cdsxt.web.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.web.dao.MenuDao;
import com.cdsxt.web.dao.ModuleDao;
import com.cdsxt.web.dao.RoleDao;
import com.cdsxt.web.dao.RoleModuleDao;
import com.cdsxt.web.po.Menu;
import com.cdsxt.web.po.Module;
import com.cdsxt.web.po.Role;
import com.cdsxt.web.po.RoleModule;
import com.cdsxt.web.service.RoleService;
import com.cdsxt.web.vo.ModuleVo;
import com.cdsxt.web.vo.RoleVo;
import com.google.gson.Gson;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Autowired
	private MenuDao menuDao;

	@Autowired
	private ModuleDao moduleDao;
	
	@Autowired
	private RoleModuleDao roleModuleDao;

	@Override
	public List<Role> findAllRole() {
		List<Role> roles = roleDao.findAllRole();
		return roles;
	}

	@Override
	public Role findById(Integer roleId) {
		return roleDao.findById(roleId);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateOrAddRole(Role role, Integer[] menuIds) {
		if (menuIds != null) {
			Set<Menu> roleMenus = new HashSet<Menu>();
			for (int i = 0; i < menuIds.length; i++) {
				Menu menu = menuDao.findById(menuIds[i]);
				roleMenus.add(menu);
			}
			role.setMenus(roleMenus);
			if (role.getRoleId() != null) {
				roleDao.updateRole(role);
			} else {
				roleDao.addRole(role);
			}
		} else {
			roleDao.updateRole(role);
		}
	}

	@Override
	public Role findByName(String name) {
		return roleDao.findByName(name);

	}

	// 删除角色
	@Override
	@Transactional(readOnly = false)
	public void deleteRole(Role role) {
		this.roleDao.deleteRole(role);
	}

	// 通过角色，获取该角色的功能模块
	@Override
	public List<ModuleVo> findRoleModule(Role role) {
		// 1获取该角色的功能模块
		Byte addId = 1;
		Byte deleteId = 2;
		Byte updateId = 4;
		Byte findId = 8;
		Set<RoleModule> roleModules = role.getRoleModules();
		List<ModuleVo> rmVos = new ArrayList<ModuleVo>();
		for (RoleModule rm : roleModules) {
			ModuleVo moduleVo = new ModuleVo();
			moduleVo.setModuleId(rm.getModule().getId());
			moduleVo.setModuleName(rm.getModule().getModuleName());
			Integer powerId = rm.getPowerCode();
			if ((addId & powerId) == addId) {
				moduleVo.setAdd(addId);
			}
			if ((deleteId & powerId) == deleteId) {
				moduleVo.setDelete(addId);
			}
			if ((updateId & powerId) == updateId) {
				moduleVo.setUpdate(addId);
			}
			if ((findId & powerId) == findId) {
				moduleVo.setFind(addId);
			}
			rmVos.add(moduleVo);
		}

		// 2系统内所有的功能模块
		List<ModuleVo> moduleVos = new ArrayList<ModuleVo>();
		List<Module> modules = moduleDao.findAll();
		for (int i = 0; i < modules.size(); i++) {
				Module module = modules.get(i);
				ModuleVo moduleVo = new ModuleVo();
				moduleVo.setModuleId(module.getId());
				if(rmVos.contains(moduleVo)){
					
				}else{
					moduleVo.setModuleName(module.getModuleName());
					rmVos.add(moduleVo);
				}
		}
		Collections.sort(rmVos);
		return rmVos;
	}

	//修改角色的模块权限
	@Override
	@Transactional(readOnly=false)
	public void updateRoleModule(Integer roleId,String moduleJsons){
		//获取需要修改的角色
		Role role=roleDao.findById(roleId);
		//清空该角色的所有权限
		Set<RoleModule> roleModules=role.getRoleModules();
		for(RoleModule rm:roleModules){
			roleModuleDao.deleteRoleModule(rm);
		}
		String str=moduleJsons.substring(1, moduleJsons.length()-1).replace("},{","}_{");
		String[] strs=str.split("_");
		Gson gson=new Gson();
		List<ModuleVo> moVos=new ArrayList<ModuleVo>();
		for(int i=0;i<strs.length;i++){
			ModuleVo moduleVo=gson.fromJson(strs[i], ModuleVo.class);
			moVos.add(moduleVo);
		}
		Set<RoleModule> newRoleModules=new HashSet<RoleModule>();
		for(ModuleVo m:moVos){
			RoleModule newrm=new RoleModule();
			newrm.setRole(role);
			newrm.setPowerCode(m.getPowerCode());
			newrm.setModule(moduleDao.findById(m.getModuleId()));
			newRoleModules.add(newrm);
		}
		//保存新的权限
		role.setRoleModules(newRoleModules);
		roleDao.updateRole(role);
	}
	//根据角色，返回一个Map,键为url,值为powerCode
	@Override
	public Map<String, Integer> RolePowercodeUrl(Role role){
		Map<String, Integer> roleMap=new HashMap<String, Integer>();
		Set<RoleModule> rms=role.getRoleModules();
		for (RoleModule roleModule : rms) {
			roleMap.put(roleModule.getModule().getModule_url(), roleModule.getPowerCode());
		}
		return roleMap;
	}
	//查询总条数
	@Override
	public long findAllCount(){
		return roleDao.findAllCount();
	}
	//分页查询角色
	@Override
	public List<Role> findForPage(int startRow,int pageRow){
		return roleDao.findForPage(startRow, pageRow);
	}
	//找到RoleVo
	@Override
	public List<RoleVo> findAllRoleVo(){
		List<Role> roles=roleDao.findAllRole();
		List<RoleVo> roleVos=new ArrayList<RoleVo>();
		for (Role role : roles) {
			roleVos.add(new RoleVo(role.getRoleId(), role.getRoleName()));
		}
		return roleVos;
	}
	
}
