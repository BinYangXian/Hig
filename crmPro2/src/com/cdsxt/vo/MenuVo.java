package com.cdsxt.vo;

import com.cdsxt.po.Menu;

public class MenuVo {
	
	private Integer menuId;
	private String menuName;
	private String menuUrl;
	private String prompt;
	private Integer parentId = 0;
	
	
	public MenuVo(Menu menu) {
		if(menu==null){
			throw new IllegalArgumentException("参数不能为空!");
		}
		
		this.menuId = menu.getMenuId();
		this.menuName = menu.getMenuName();
		this.menuUrl = menu.getMenuUrl();
		this.prompt = menu.getPrompt();
		Menu parent = menu.getParent();
		if(parent!=null){
			this.parentId = parent.getMenuId();
		}
		
	}
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
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
