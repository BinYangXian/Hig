package com.cdsxt.po;

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
	
	@Id
	@SequenceGenerator(name="seqModule",sequenceName="seq_crm_module")
	@GeneratedValue(generator="seqModule")
	@Column(name="module_id")
	private Integer id;
	@Column(name="module_name")
	private String name;
	@Column(name="module_url")
	private String url;
	
	@OneToMany(mappedBy="module")
	private Set<RoleModule> roleModule;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<RoleModule> getRoleModule() {
		return roleModule;
	}
	public void setRoleModule(Set<RoleModule> roleModule) {
		this.roleModule = roleModule;
	}

}
