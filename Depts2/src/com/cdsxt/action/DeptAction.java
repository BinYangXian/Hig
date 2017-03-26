package com.cdsxt.action;

import java.util.List;

import com.cdsxt.po.Dept;
import com.cdsxt.service.DeptService;
import com.cdsxt.service.impl.DeptServiceImpl;

public class DeptAction {
	
	private List<Dept> depts;
	private DeptService deptService = new DeptServiceImpl();
	
	public String findAll(){
		this.depts = this.deptService.findAll();
		return "depts";
	}
	public String show(){
		this.depts = this.deptService.findAll();
		return "show";
	}

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}
}
