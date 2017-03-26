package com.cdsxt.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Menu;
import com.cdsxt.service.MenuService;
import com.cdsxt.vo.MenuVo;

@Controller
@Scope("prototype")
public class MenuAction {
	
	
	@Autowired
	private MenuService menuService;
	
	private List<Menu> menus;
	private List<MenuVo> vos;
	
	public String findAll(){
		this.menus = this.menuService.findAll();
		return "menus";
	}
	
	public String findAllToLeft(){
		this.vos = this.menuService.findAllToLeft();
		return "left";
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public List<MenuVo> getVos() {
		return vos;
	}

	public void setVos(List<MenuVo> vos) {
		this.vos = vos;
	}

}
