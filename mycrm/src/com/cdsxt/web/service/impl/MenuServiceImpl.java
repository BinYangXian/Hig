package com.cdsxt.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.web.dao.MenuDao;
import com.cdsxt.web.po.Menu;
import com.cdsxt.web.po.Role;
import com.cdsxt.web.service.MenuService;
import com.cdsxt.web.vo.MenuVo;

@Service
@Transactional(readOnly = true)
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	//找到数据库内，所有的菜单
	@Override
	public List<MenuVo> findAllMenu(){
		List<Menu> menus=this.menuDao.findAll();
		List<MenuVo> menuVos=new ArrayList<MenuVo>();
		for (int i = 0; i < menus.size(); i++) {
			menuVos.add(new MenuVo(menus.get(i)));
		}
		return menuVos;
	}
	
	@Override
	// 找到对应角色的所有的菜单
	public List<MenuVo> findAll(Role role) {
		List<Menu> menus = menuDao.findAll();
		List<MenuVo> menuVos = new ArrayList<MenuVo>();
		Set<Menu> roleMenus = role.getMenus();
		for (Menu m : menus) {
			MenuVo menuVo = new MenuVo();
			menuVo.setMenuVoId(m.getMenuId());
			menuVo.setMenuVoName(m.getMenuName());
			if(m.getParent()==null){
				menuVo.setMenuVoParentId(0);
			}else{
				menuVo.setMenuVoParentId(m.getParent().getMenuId());
			}
			if (roleMenus.contains(m)) {
				menuVo.setChecked(true);
			}
			menuVos.add(menuVo);
		}
		return menuVos;
	}
	
	//根据ID查找
	@Override
	public Menu findById(Integer id){
		return this.menuDao.findById(id);
	}
	
	

}
