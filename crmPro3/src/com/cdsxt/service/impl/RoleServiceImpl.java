package com.cdsxt.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.MenuDao;
import com.cdsxt.dao.RoleDao;
import com.cdsxt.po.Menu;
import com.cdsxt.po.Role;
import com.cdsxt.service.RoleService;

@Service
@Transactional(readOnly=true)
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public Role findById(Integer id) {
		return this.roleDao.findById(id);
	}

	@Override
	public List<Role> findByIds(Integer[] ids) {
		return this.roleDao.findByIds(ids);
	}

	@Override
	public List<Role> findAll() {
		return this.roleDao.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void updateChooseMenu(Integer roleId, Integer[] menuIds) {
		// TODO Auto-generated method stub
		//根据id得到角色
		Role role = this.roleDao.findById(roleId);
		if(role==null){
			return;
		}
		
		Set<Menu> menus = role.getMenus();
		//清空关系
		if(menus==null){
			menus = new HashSet<>();
		}
		
		menus.clear();
		
		
		//重新建立联系
		if(menuIds!=null && menuIds.length>0 ){
			//查询对应的菜单  设置到对应的set中
			List<Menu> ms = menuDao.findByIds(menuIds);
			menus.addAll(ms);
		}
		
		//更新数据
		this.roleDao.update(role);
	}

}
