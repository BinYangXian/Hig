package com.cdsxt.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;

@Controller
@Scope("prototype")
public class EmpAction {
	
	private List<Emp> emps;
	
	@Autowired
	private EmpService empService;

	public String findAll(){
		this.emps = this.empService.findAll();
		return "findAll";
		
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
