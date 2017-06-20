package com.cdsxt.po;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="crm_menu")
public class Menu {
	
	@Id
	@SequenceGenerator(name="seqMenu",sequenceName="seq_crm_menu")
	@GeneratedValue(generator="seqMenu")
	@Column(name="menu_id")
	private Integer menuId;
	@Column(name="menu_name")
	private String menuName;
	
	private String prompt;
	@Column(name="menu_url")
	private String menuUrl;
	@Column(name="menu_level")
	private Integer menuLevel;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Menu parent;
	
	@OneToMany(mappedBy="parent")
	private Set<Menu> childs;
	
	
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
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getMenuLevel() {
		return menuLevel;
	}
	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}
	public Menu getParent() {
		return parent;
	}
	public void setParent(Menu parent) {
		this.parent = parent;
	}
	public Set<Menu> getChilds() {
		return childs;
	}
	public void setChilds(Set<Menu> childs) {
		this.childs = childs;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
