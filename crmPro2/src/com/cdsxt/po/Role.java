package com.cdsxt.po;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="crm_role")
public class Role {
	
	@Id
	@SequenceGenerator(name="seqRole",sequenceName="seq_crm_Role")
	@GeneratedValue(generator="seqRole")
	@Column(name="role_id")
	private Integer roleId;
	@Column(name="role_name")
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	private Set<Users> users = Collections.emptySet();

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

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
	

}
