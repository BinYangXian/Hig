package com.cdsxt.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.web.po.Role;
import com.cdsxt.web.service.MenuService;
import com.cdsxt.web.service.RoleService;
import com.cdsxt.web.vo.MenuVo;

@Controller
@Scope("prototype")
public class MenuAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
	private Integer roleId;
	
	private List<MenuVo> menuVos;
	
	//找到所有菜单
	public String findAll(){
		if(roleId!=null){
			Role updateRole=roleService.findById(roleId);
			menuVos=menuService.findAll(updateRole);
		}else {
			menuVos=menuService.findAllMenu();
		}
		if(menuVos!=null||!menuVos.isEmpty()){
		
			return "findAll";
		}else{
			return "error";
		}
	}
	

	public List<MenuVo> getMenuVos() {
		return menuVos;
	}

	public void setMenuVos(List<MenuVo> menuVos) {
		this.menuVos = menuVos;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
	
}
