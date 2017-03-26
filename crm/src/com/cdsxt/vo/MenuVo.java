package com.cdsxt.vo;

public class MenuVo {

	private Integer menuId;
	private Integer parentId;
	private String menuName;
	private String menuUrl;
	
	private Boolean checked = false;
	
	public MenuVo() {
		super();
	}
	
	public MenuVo(Integer menuId, Integer parentId, String menuName, String menuUrl) {
		super();
		this.menuId = menuId;
		this.parentId = parentId==null?0:parentId;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
