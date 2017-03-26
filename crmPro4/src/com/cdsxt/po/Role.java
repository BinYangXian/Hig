package com.cdsxt.po;

import java.util.Collections;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@ManyToMany
	@JoinTable(
		name="crm_role_menu",
		joinColumns={
			@JoinColumn(name="role_id")
		},
		inverseJoinColumns={
			@JoinColumn(name="menu_id")
		}
	)
	private Set<Menu> menus = Collections.emptySet();
	
	@OneToMany(mappedBy="role")
	private Set<RoleModule> roleModules = Collections.emptySet();

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

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public Set<RoleModule> getRoleModules() {
		return roleModules;
	}

	public void setRoleModules(Set<RoleModule> roleModules) {
		this.roleModules = roleModules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (roleName == null) {
			if (other.roleName != null)
				return false;
		} else if (!roleName.equals(other.roleName))
			return false;
		return true;
	}
	

}
