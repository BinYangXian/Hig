package com.cdsxt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.RoleDAO;
import com.cdsxt.po.Menu;
import com.cdsxt.po.Role;
import com.cdsxt.po.RoleModule;
import com.cdsxt.service.MenuService;
import com.cdsxt.service.RoleService;
import com.cdsxt.vo.RoleVo;

@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private MenuService menuService;
	
	@Override
	public List<Role> findAll() {
		return this.roleDAO.findAll();
	}

	@Override
	public List<Menu> findMenuInRole(Integer id) {
		Role role = this.roleDAO.findById(id);
		Set<Menu> menus = role.getMenus();
		List<Menu> ms = new ArrayList<Menu>();
		if(menus!=null){
			ms.addAll(menus);
		}
		return ms;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateChooseMenu(Integer id, Integer[] menuIds) {
		// TODO Auto-generated method stub
		Role role = this.roleDAO.findById(id);
		if(role==null){
			return ;
		}
		
		Set<Menu> menus = role.getMenus();
		
		if(menus==null){
			menus = new HashSet<Menu>();
		}
		
		if(!menus.isEmpty()){
			menus.clear();
		}
		
		if(menuIds!=null && menuIds.length>0){
			List<Menu> ms = this.menuService.findByIds(menuIds);
			menus.addAll(ms);
		}
		this.roleDAO.update(role);
	}

	@Override
	public List<RoleVo> findAllToVo() {
		// TODO Auto-generated method stub
		return this.roleDAO.findAllToVo();
	}

	@Override
	public Map<Integer, Integer> findPowersByRoleId(Integer id) {
		//模块和权限码的对应关系
		Map<Integer,Integer> powers = new HashMap<Integer, Integer>();
		
		Role role = this.roleDAO.findById(id);
		Set<RoleModule> rms = role.getRoleModule();
		
		if(rms!=null){
			for(RoleModule rm:rms){
				powers.put(rm.getModule().getId(), rm.getPowerCode());
			}
		}
		return powers;
	}

}
