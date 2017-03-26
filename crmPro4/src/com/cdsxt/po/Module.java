package com.cdsxt.po;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="crm_module")
public class Module {
	//ID
	@Id
	@SequenceGenerator(name="seqModule",sequenceName="seq_crm_module")
	@GeneratedValue(generator="seqModule")
	@Column(name="module_id")
	private Integer moduleId;
	//模块名称
	@Column(name="module_name")
	private String moduleName;
	//模块地址
	@Column(name="module_url")
	private String moduleUrl;
	
	@OneToMany(mappedBy="module")
	private Set<RoleModule> roleModules = Collections.emptySet();;
	
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getModuleUrl() {
		return moduleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		this.moduleUrl = moduleUrl;
	}
	public Set<RoleModule> getRoleModules() {
		return roleModules;
	}
	public void setRoleModules(Set<RoleModule> roleModules) {
		this.roleModules = roleModules;
	}
}
