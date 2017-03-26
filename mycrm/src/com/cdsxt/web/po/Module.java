package com.cdsxt.web.po;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="crm_module")
public class Module {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="module_id")
	private int id;
	@Column(name="module_name")
	private String moduleName;
	@Column(name="module_url")
	private String module_url;
	
	@OneToMany(mappedBy="module")
	private Set<RoleModule> roleModules;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModule_url() {
		return module_url;
	}

	public void setModule_url(String module_url) {
		this.module_url = module_url;
	}

	public Set<RoleModule> getRoleModules() {
		return roleModules;
	}

	public void setRoleModules(Set<RoleModule> roleModules) {
		this.roleModules = roleModules;
	}
	
	
	
}
