package com.cdsxt.po;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
@Entity
@Table
public class Users {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer userid;
	
	private String usename;
	private String usepassword;
	@ManyToMany(mappedBy="users")
	private Set<Role> roles =Collections.emptySet();
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getUsepassword() {
		return usepassword;
	}
	public void setUsepassword(String usepassword) {
		this.usepassword = usepassword;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
