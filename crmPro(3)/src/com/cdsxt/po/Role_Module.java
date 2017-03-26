package com.cdsxt.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Role_Module {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer rmid;
	
	private Integer powercode;
	@ManyToOne
	private Role role;
	@ManyToOne
	private Module module;
	public Integer getRmid() {
		return rmid;
	}
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}
	
	public Integer getPowercode() {
		return powercode;
	}
	public void setPowercode(Integer powercode) {
		this.powercode = powercode;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	
	
	
}
