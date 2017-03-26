package com.cdsxt.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Role;
import com.cdsxt.po.Users;
import com.cdsxt.service.RoleService;
import com.cdsxt.service.UsersService;
import com.cdsxt.vo.RoleVo;

@Controller
@Scope("prototype")
public class UsersAction {

	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RoleService roleService;
	
	private List<Users> users;
	//接受单个用户
	private Users user;
	
	//角色列表
	private List<Role> roles;
	
	//接受已经选中的角色
	private Integer[] roleIds;
	
	private List<RoleVo> roleVos;
	
	public String findAll(){
		this.users = this.usersService.findAll();
		return "users";
	}
	//查询所有的角色 用于 在用户界面进行分配
	public String findAllRoleToChoose(){
		this.roles = this.roleService.findAll();
		return "findAllRoleToChoose";
	}
	
	//更新已经选中的角色
	public String updateChooseRole(){
		if(this.user!=null && this.user.getId()!=null){
			this.usersService.updateChooseRole(this.user.getId(),roleIds);
		}
		return "updateChooseRole";
	}
	
	public String findAllRoleInUsersToJson(){
		if(this.user!=null && this.user.getId()!=null){
			this.roleVos = this.usersService.findAllRoleInUsersToJson(this.user.getId());
		}
		return "findAllRoleInUsersToJson";
	}
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Integer[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
	public List<RoleVo> getRoleVos() {
		return roleVos;
	}
	public void setRoleVos(List<RoleVo> roleVos) {
		this.roleVos = roleVos;
	}
}
