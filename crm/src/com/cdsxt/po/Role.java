package com.cdsxt.po;

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
	@SequenceGenerator(name="seqRole",sequenceName="seq_crm_role")
	@GeneratedValue(generator="seqRole")
	@Column(name="role_id")
	private Integer id;
	
	@Column(name="role_name")
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Set<Users> users;
	
	
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
	private Set<Menu> menus;

	@OneToMany(mappedBy="role")
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

	public Set<RoleModule> getRoleModule() {
		return roleModule;
	}

	public void setRoleModule(Set<RoleModule> roleModule) {
		this.roleModule = roleModule;
	}
}
