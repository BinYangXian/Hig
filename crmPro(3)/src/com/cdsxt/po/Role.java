package com.cdsxt.po;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;
@Entity
@Table
public class Role {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer roleid;
	private String rolename;
	@ManyToMany(mappedBy="roles")
	private Set<Menu> menus=Collections.emptySet();
	
	@ManyToMany
	private Set<Users>users=Collections.emptySet();
	
	@OneToMany(mappedBy="module")
	Set<Role_Module> role_Modules =Collections.emptySet();
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<Users> getUsers() {
		return users;
	}
	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	
	
	

}
