package com.cdsxt.vo;

import org.springframework.util.Assert;

import com.cdsxt.po.Role;

public class RoleVo {
	
	private Integer roleId;
	private String roleName;
	
	public RoleVo(Role role) {
		Assert.notNull(role, "角色不能为空");
		this.roleId = role.getRoleId();
		this.roleName = role.getRoleName();
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	

}
