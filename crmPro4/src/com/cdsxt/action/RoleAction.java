package com.cdsxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import com.cdsxt.po.Menu;
import com.cdsxt.po.Module;
import com.cdsxt.po.Role;
import com.cdsxt.po.RoleModule;
import com.cdsxt.service.MenuService;
import com.cdsxt.service.ModuleService;
import com.cdsxt.service.RoleService;
import com.cdsxt.util.PermissionUtils;
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
	
	private List<Role> roles;
	private List<MenuVo> vos;
	
	private List<Module> modules;
	private Integer []menuIds;
	private Role role;
	
	private Integer roleId;
	private Integer moduleId;
	
	private Integer powerCode;
	private Boolean add = false;
	
	@Autowired
	private PermissionUtils permission;
	//模块id和权限码的对应关系
	private Map<Integer,Integer> powers = new HashMap<>();
	
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
	
	
	//显示分配模块的页面
	public String updateChooseModuleView(){
		//得到所有的模块
		this.modules = this.moduleService.findAll();
		//得到该角色所选择的模块  对应的powerCode
		if(this.roleId!=null){
			Role role = this.roleService.findById(roleId);
			Set<RoleModule> rms = role.getRoleModules();
			if(rms!=null && !rms.isEmpty()){
				powers.clear();
				for(RoleModule rm:rms){
					powers.put(rm.getModule().getModuleId(), rm.getPowerCode());
				}
			}
		}
		return "updateChooseModule";
	}
	//更新权限
	public void updateChooseModule(){
		Assert.notNull(roleId,"角色不能为空");
		Assert.notNull(moduleId,"模块不能为空");
		Assert.notNull(powerCode,"权限码不能为空");
		if(add==null){
			add = false;
		}
		this.roleService.updateChooseModule(roleId,moduleId,powerCode,add);
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

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Boolean getAdd() {
		return add;
	}

	public void setAdd(Boolean add) {
		this.add = add;
	}

	public Integer getPowerCode() {
		return powerCode;
	}

	public void setPowerCode(Integer powerCode) {
		this.powerCode = powerCode;
	}

	public PermissionUtils getPermission() {
		return permission;
	}

	public Map<Integer, Integer> getPowers() {
		return powers;
	}

}
