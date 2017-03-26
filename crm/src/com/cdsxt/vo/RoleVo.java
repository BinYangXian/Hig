package com.cdsxt.vo;

import com.cdsxt.po.Role;

public class RoleVo {
	
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public RoleVo(Role role) {
		if (role==null){
			throw new IllegalArgumentException("角色不能为空");
		}
		
		this.id = role.getId();
		this.name = role.getName();
	}
	
	public RoleVo(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public RoleVo() {
		super();
	}
}
