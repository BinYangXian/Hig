package com.cdsxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Menu;
import com.cdsxt.po.Module;
import com.cdsxt.po.Role;
import com.cdsxt.service.MenuService;
import com.cdsxt.service.ModuleService;
import com.cdsxt.service.RoleModuleService;
import com.cdsxt.service.RoleService;
import com.cdsxt.utils.Utils;
import com.cdsxt.vo.MenuVo;

@Controller
@Scope("prototype")
public class RoleAction {

	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ModuleService moduleService;
	
	@Autowired
	private RoleModuleService roleModuleService;
	
	private List<Role> roles;
	
	private List<Module> modules;
	
	private List<MenuVo> menuVos;
	//得到选中的menu节点id
	private Integer []menuIds;
	
	private Role role;
	//key  代表  moduleid	value代表 powercode
	private Map<Integer,Integer> powers = new HashMap<Integer,Integer>();
	
	//用于更新模块
	private Integer moduleId;
	private Integer powerCode;
	
	private Utils utils = new Utils();
	
	public String findAll(){
		this.roles = this.roleService.findAll();
		return "roles";
	}
	
	
	//返回页面进行选中菜单的页面
	public String findAllMenuToChooseView(){
		return "findAllMenuToChooseView";
	}
	//返回页面进行选中菜单的数据
	public String findAllMenuToChooseJson(){
		this.menuVos = new ArrayList<MenuVo>();
		if(this.role!=null && this.role.getId()!=null){
			
			//查询所有的菜单
			List<Menu> menus = this.menuService.findAll();
			//根据roleid去查询该角色所拥有的菜单列表
			List<Menu> ms = this.roleService.findMenuInRole(this.role.getId());
			
			for(Menu menu:menus){
				Menu parent = menu.getParent();
				MenuVo vo = new MenuVo();
				vo.setMenuId(menu.getMenuId());
				vo.setParentId(parent!=null?parent.getMenuId():0);
				vo.setMenuName(menu.getMenuName());
				vo.setMenuUrl(menu.getMenuUrl());
				
				for(Menu m:ms){
					if(m.getMenuId() == menu.getMenuId()){
						vo.setChecked(true);
					}
				}
				
				menuVos.add(vo);
			}
			
		}
		return "findAllMenuToChooseJson";
	}
	
	//更新选中的菜单
	public String updateChooseMenu(){
		if(this.role!=null && this.role.getId()!=null){
			this.roleService.updateChooseMenu(this.role.getId(),menuIds);
		}
		return "updateChooseMenu";
	}

	
	public String findAllModuleToChooseView(){
		this.modules = this.moduleService.findAll();
		//去查询  该角色已经拥有的权限
		if(this.role!=null && this.role.getId()!=null){
			this.powers = this.roleService.findPowersByRoleId(this.role.getId());
		}
		return "findAllModuleToChooseView";
	}
	public String findAllModuleToChooseJson(){
		
		return "findAllModuleToChooseJson";
	}
	public String updateChooseModule(){
		//更新所需要的值   有角色id  以及模块id  还有 powercode
		
		if(this.role!=null && this.role.getId()!=null && this.moduleId!=null && this.powerCode!=null){
			this.roleModuleService.updateModulePowerCode(this.role.getId(),moduleId,powerCode);
		}
		
		return "updateChooseModule";
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
	public List<MenuVo> getMenuVos() {
		return menuVos;
	}
	public void setMenuVos(List<MenuVo> menuVos) {
		this.menuVos = menuVos;
	}
	public Integer[] getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(Integer[] menuIds) {
		this.menuIds = menuIds;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public Map<Integer, Integer> getPowers() {
		return powers;
	}
	public void setPowers(Map<Integer, Integer> powers) {
		this.powers = powers;
	}
	public Utils getUtils() {
		return utils;
	}
	public void setUtils(Utils utils) {
		this.utils = utils;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public Integer getPowerCode() {
		return powerCode;
	}
	public void setPowerCode(Integer powerCode) {
		this.powerCode = powerCode;
	}
}
