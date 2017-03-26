package com.cdsxt.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//中间表
@Entity
@Table(name="crm_role_module")
public class RoleModule {
	
	@Id
	@SequenceGenerator(name="seqRm",sequenceName="seq_crm_role_module")
	@GeneratedValue(generator="seqRm")
	@Column(name="rm_id")
	private Integer rmid;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;
	
	@Column(name="power_code")
	private Integer powerCode;

	public Integer getRmid() {
		return rmid;
	}

	public void setRmid(Integer rmid) {
		this.rmid = rmid;
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

	public Integer getPowerCode() {
		return powerCode;
	}

	public void setPowerCode(Integer powerCode) {
		this.powerCode = powerCode;
	}

}
