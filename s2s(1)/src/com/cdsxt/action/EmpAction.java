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
	
	private Emp emp;
	
	@Autowired
	private EmpService empService;

	public String findAll(){
		this.emps = this.empService.findAll();
		return "findAll";
		
	}
	
	public String updateEmpView(){
		Integer empno = null;
		if(this.emp!=null){
			empno = this.emp.getEmpno();
		}
		if(empno!=null){
			this.emp = this.empService.findByEmpno(empno);
		}
		
		return "update";
		
	}
	
	public String updateEmp(){
		if(this.emp!=null){
			this.empService.update(emp);
		}
		return "update-success";
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	
}
