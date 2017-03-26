package com.cdsxt.web.po;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="crm_menu")
public class Menu {
	
	@Id
	@Column(name="menu_id")
	private Integer menuId;
	@Column(name="menu_name")
	private String menuName;
	@Column(name="menu_url")
	private String menuUrl;
	@OneToMany(mappedBy="parent")
	private Set<Menu> childs;
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu parent;
	
	@ManyToMany(mappedBy="menus")
	private Set<Role> roles;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Set<Menu> getChilds() {
		return childs;
	}

	public void setChilds(Set<Menu> childs) {
		this.childs = childs;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}


	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.menuId.equals(((Menu)obj).getMenuId());
	}

	

	
	
	
}
