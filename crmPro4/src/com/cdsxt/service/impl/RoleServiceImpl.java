package com.cdsxt.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.MenuDao;
import com.cdsxt.dao.ModuleDao;
import com.cdsxt.dao.RoleDao;
import com.cdsxt.dao.RoleModuleDao;
import com.cdsxt.po.Menu;
import com.cdsxt.po.Module;
import com.cdsxt.po.Role;
import com.cdsxt.po.RoleModule;
import com.cdsxt.service.RoleService;

@Service
@Transactional(readOnly=true)
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

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateChooseModule(Integer roleId, Integer moduleId, Integer powerCode, Boolean add) {
		// TODO Auto-generated method stub
		//根据角色id和模块id查询中间表关系
		//add  true  叠加    false  移除
		RoleModule rm = this.roleModuleDao.findByRoleIdAndModuleId(roleId, moduleId);
		if(rm==null){
			if(add){
				rm = new RoleModule();
				Role role = this.roleDao.findById(roleId);
				Module module = this.moduleDao.findById(moduleId);
				rm.setRole(role);
				rm.setModule(module);
				rm.setPowerCode(powerCode);
			}else{
				return ;
			}
		}else{
			//更新权限码
			
			Integer code = rm.getPowerCode();
			if(code==null){
				code = 0;
			}
			
			if(add){
				//叠加权限
				//如果原来有权限 这跳出
				//否则 叠加权限
				if(((code&powerCode) != powerCode)){
					rm.setPowerCode(code|powerCode);
				}
			}else{
				//如果以前有权限  则减去
				// 否则 不操作
				if((code&powerCode) == powerCode){
					rm.setPowerCode(code^powerCode);
				}
			}
			
		}
		//判断该记录是否有效  只要没有任何的执行权限   就判定为无效
		if(rm.getPowerCode() == 0){
			this.roleModuleDao.delete(rm);
		}else{
			this.roleModuleDao.saveOrUpdate(rm);
		}
	}

}
