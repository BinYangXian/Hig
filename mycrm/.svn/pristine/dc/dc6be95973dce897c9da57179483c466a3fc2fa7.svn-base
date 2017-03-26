package com.cdsxt.web.po;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="crm_role",uniqueConstraints={@UniqueConstraint(columnNames={"role_name"})})
public class Role {
	
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="crm_role_menu",
				joinColumns={
						@JoinColumn(name="role_id")
				},
				inverseJoinColumns={
						@JoinColumn(name="menu_id")
				})
	@OrderBy("menu_id asc")
	private Set<Menu> menus;
	
	@OneToMany(mappedBy="role")
	@Cascade(value={org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	private Set<RoleModule> roleModules;
	
	
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
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


	



	
	



	
	
	
}
