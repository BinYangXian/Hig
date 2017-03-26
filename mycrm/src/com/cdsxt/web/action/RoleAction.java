package com.cdsxt.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.cdsxt.web.po.Role;
import com.cdsxt.web.service.RoleService;
import com.cdsxt.web.util.PageUtil;
import com.cdsxt.web.vo.ModuleVo;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class RoleAction extends ActionSupport{
	
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private RoleService roleService;
	
	private Integer roleId;
	
	private String newName;
	
	private List<Role> roles;
	
	private Integer[] menuIds;
	
	private Integer[] roleIds;
	
	private String errorMsg;
	
	private List<ModuleVo> moduleVos;
	
	private Role role; 
	
	private Integer curPage;
	
	private PageUtil page;
	
	//找到所有角色
	public String findAll(){
		int rowCount=(int) roleService.findAllCount();
		curPage=1;
		page=new PageUtil(curPage, rowCount);
		roles=roleService.findForPage(page.getStartRow(), page.getPageRow());
		return "findAll";
	}
	//新增角色
	public String addRole(){
		if(!StringUtils.hasLength(newName)){
			this.addFieldError("msg", "职务名不能为空，请重新输入");
			return "error";
		}
		if(roleService.findByName(newName)==null){
			role=new Role();
			role.setRoleName(newName);
			roleService.updateOrAddRole(role, menuIds);
			return "addRole";
		}else {
			this.addFieldError("msg", "职务名重复，请重新输入");
			return "error";
		}
	}
	
	//修改角色菜单
	public String updateMenu(){
		role=roleService.findById(roleId);
		roleService.updateOrAddRole(role, menuIds);
	    return "updateMenu";
	}
	
	//修改角色名,从页面接受ajax参数
	public String updateName(){
		role=roleService.findById(roleId);
		if(roleService.findByName(newName)==null){
			role.setRoleName(newName);
			roleService.updateOrAddRole(role, null);
		}else {
			errorMsg="该用户名已经存在!";
		}
		return "updateName";
	}
	
	//删除角色
	public String deleteRole(){
		for(Integer i : roleIds){
			roleService.deleteRole(roleService.findById(i));
		}
		errorMsg="删除完成";
		return "deleteRole";
	}
	
	
	//找到角色所拥有模块,进行权限分配
	public String findRoleModule(){
		role=roleService.findById(roleId);
		moduleVos=roleService.findRoleModule(role);
		
		return "findRoleModule";
	}
	
	private String moduleJsons;
 	//分配角色各个模块的权限值
	public String updateModule(){
		roleService.updateRoleModule(roleId, moduleJsons);
		errorMsg="修改成功";
		return "updateModule";
	}
	
	//分页查询
	public String findAllToPage(){
		int rowCount=(int) roleService.findAllCount();
		
		page=new PageUtil(curPage, rowCount);
		roles=roleService.findForPage(page.getStartRow(), page.getPageRow());
		return "findAllToPage";
	}


	public String getModuleJsons() {
		return moduleJsons;
	}

	public void setModuleJsons(String moduleJsons) {
		this.moduleJsons = moduleJsons;
	}

	//----分割线
	public Integer[] getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(Integer[] menuIds) {
		this.menuIds = menuIds;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Integer[] getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}

	public List<ModuleVo> getModuleVos() {
		return moduleVos;
	}

	public void setModuleVos(List<ModuleVo> moduleVos) {
		this.moduleVos = moduleVos;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	
	
	
	
}
