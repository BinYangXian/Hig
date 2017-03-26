package com.cdsxt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Menu;
import com.cdsxt.po.Role;
import com.cdsxt.service.MenuService;
import com.cdsxt.service.RoleService;
import com.cdsxt.vo.MenuVo;

@Controller
@Scope("prototype")
public class RoleAction {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	private List<Role> roles;
	private List<MenuVo> vos;
	private Integer []menuIds;
	private Role role;
	
	private Integer roleId;
	
	//显示全部
	public String findAll(){
		this.roles = this.roleService.findAll();
		return "findAll";
	}
	
	//用于显示选择菜单的页面
	public String updateChooseMenuJson(){
		this.vos = new ArrayList<>();
		if(this.roleId!=null){
			Role role = this.roleService.findById(roleId);
			
			if(role!=null){
				Set<Menu> ms = role.getMenus();
				List<Menu> menus = this.menuService.findAll();
				for(Menu menu :menus){
					MenuVo vo = new MenuVo(menu);
					this.vos.add(vo);
					if(ms.contains(menu)){
						vo.setChecked(true);
					}
				}
			}
		}
		return "updateChooseMenuJson";
	}
	//用于显示选择菜单的页面
	public String updateChooseMenuView(){
		
		return "updateChooseMenu";
	}
	
	//用于真正的选择菜单
	public String updateChooseMenu(){
		if(this.roleId!=null){
			this.roleService.updateChooseMenu(roleId,menuIds);
		}else{
			return "error";
		}
		
		return "ChooseMenu-success";
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<MenuVo> getVos() {
		return vos;
	}

	public void setVos(List<MenuVo> vos) {
		this.vos = vos;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(Integer[] menuIds) {
		this.menuIds = menuIds;
	}

}
