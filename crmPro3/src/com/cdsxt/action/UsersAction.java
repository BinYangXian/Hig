package com.cdsxt.action;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.dao.RoleDao;
import com.cdsxt.po.Role;
import com.cdsxt.po.Users;
import com.cdsxt.service.UsersService;

@Controller
@Scope("prototype")
public class UsersAction {
	
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RoleDao roleService;
	private List<Users> users;
	
	//用于接受用户数据
	private Users user;
	//用于接受选中的角色id
	private Integer []roleIds;
	
	private List<Role> roles;
	
	//查询全部用户
	public String findAll(){
		this.users = this.usersService.findAll();
		return "findAll";
	}
	
	//表示渲染选中角色的页面
	public String updateChooseRoleView(){
		this.roles = this.roleService.findAll();
		return "updateChooseRole";
	}
	//表示更新选中的角色
	public String updateChooseRole(){
		Integer id = null;
		if(this.user!=null){
			id = this.user.getId();
		}
		if(id==null){
			return "error";
		}
		
		this.usersService.updateChooseRole(id,roleIds);
		return "updateChooseRole-success";
	}
	
	//查询指定用户中的选中角色
	public String updateFindCheckedRoles(){
		Integer id = null;
		if(this.user!=null){
			id = this.user.getId();
		}
		if(id==null){
			return "error";
		}
		
		Users u = this.usersService.findById(id);
		if(u==null){
			return "error";
		}
		
		Set<Role> roles = u.getRoles();
		if(roles==null || roles.isEmpty()){
			roleIds = new Integer[]{};
		}else{
			roleIds = new Integer[roles.size()];
		}
		int i=0;
		for(Role role:roles){
			roleIds[i] = role.getRoleId();
			i++;
		}
		return "updateFindCheckedRoles";
	}
	public List<Users> getUsers() {
		return users;
	}
	public void setUsers(List<Users> users) {
		this.users = users;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
