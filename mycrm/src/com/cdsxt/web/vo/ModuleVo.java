package com.cdsxt.web.vo;

public class ModuleVo implements Comparable<ModuleVo>{
	
	private Integer moduleId;
	private String ModuleName;
	private Integer powerCode;
	private Byte add;
	private Byte delete;
	private Byte update;
	private Byte find;
	
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	public String getModuleName() {
		return ModuleName;
	}
	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
	public Byte getAdd() {
		return add;
	}
	public void setAdd(Byte add) {
		this.add = add;
	}
	public Byte getDelete() {
		return delete;
	}
	public void setDelete(Byte delete) {
		this.delete = delete;
	}
	public Byte getUpdate() {
		return update;
	}
	public void setUpdate(Byte update) {
		this.update = update;
	}
	public Byte getFind() {
		return find;
	}
	public void setFind(Byte find) {
		this.find = find;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.moduleId==(((ModuleVo)obj).getModuleId())){
			return true;
		}else {
			return false;
		}
	}
	public Integer getPowerCode() {
		return powerCode;
	}
	public void setPowerCode(Integer powerCode) {
		this.powerCode = powerCode;
	}
	@Override
	public int compareTo(ModuleVo o) {
		if(this.moduleId>o.moduleId){
			return -1;
		}else {
			return 1;
		}
	
	}
	
	
}
