package com.cdsxt.web.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="crm_role_module")
public class RoleModule {
	
	@Id
	@Column(name="rm_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="power_code")
	private int powerCode;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPowerCode() {
		return powerCode;
	}

	public void setPowerCode(int powerCode) {
		this.powerCode = powerCode;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
