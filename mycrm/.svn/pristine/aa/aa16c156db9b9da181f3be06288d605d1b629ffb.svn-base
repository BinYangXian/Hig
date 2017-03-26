package com.cdsxt.web.vo;

import com.cdsxt.web.po.Menu;

public class MenuVo {
	private Integer menuVoId;
	private String menuVoName;
	private Integer menuVoParentId;
	private String menuVoUrl;
	private boolean checked=false;
	
	
	public MenuVo() {
	}

	public MenuVo(Menu menu) {
		this.menuVoId=menu.getMenuId();
		this.menuVoName=menu.getMenuName();
		if(menu.getParent()==null){
			this.menuVoParentId=0;
		}else {
			this.menuVoParentId=menu.getParent().getMenuId();
		}
		menuVoUrl=(menu.getMenuUrl()==null?"":menu.getMenuUrl());
	}

	public Integer getMenuVoId() {
		return menuVoId;
	}

	public void setMenuVoId(Integer menuVoId) {
		this.menuVoId = menuVoId;
	}

	public String getMenuVoName() {
		return menuVoName;
	}

	public void setMenuVoName(String menuVoName) {
		this.menuVoName = menuVoName;
	}

	public Integer getMenuVoParentId() {
		return menuVoParentId;
	}

	public void setMenuVoParentId(Integer menuVoParentId) {
		this.menuVoParentId = menuVoParentId;
	}

	public String getMenuVoUrl() {
		return menuVoUrl;
	}

	public void setMenuVoUrl(String menuVoUrl) {
		this.menuVoUrl = menuVoUrl;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "MenuVo [menuVoId=" + menuVoId + ", menuVoName=" + menuVoName + ", menuVoParentId=" + menuVoParentId
				+ ", menuVoUrl=" + menuVoUrl + ", checked=" + checked + "]";
	}
	
	
	
	
}
