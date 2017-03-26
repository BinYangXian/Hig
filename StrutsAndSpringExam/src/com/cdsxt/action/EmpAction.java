package com.cdsxt.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.dao.impl.EmpDaoImpl;
import com.cdsxt.po.Emp;
import com.cdsxt.service.EmpService;
import com.google.gson.Gson;

@Controller
@Scope("prototype")
public class EmpAction {
	private List<Emp> emps;
	
	@Autowired
	private EmpService empService;
	private Emp emp;
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String findAll(){
		this.emps = this.empService.findAll();
		return "findAll";
		
	}

	public String save(){
		if(this.emp!=null){
			this.empService.addEmp(emp);
		}
		return "save-success";
		
	}
	public String update(){
		if(this.emp!=null){
			this.empService.changeEmp(emp);
		}
		return "save-success";
		
	}
	public String delete(){
		System.out.println(emp.getEmpno());
		if(this.emp.getEmpno()!=null){
			this.empService.delete(emp.getEmpno());
		}
		return "save-success";
		
	}
	
	public String findOne(){
		Integer empno = null;
		if(this.emp!=null){
			empno = this.emp.getEmpno();
		}
		if(empno!=null){
			this.emp = this.empService.findEmpById(empno);
			String json = new Gson().toJson(this.emp);
			if(json==null){
				json = "{}";
			}
			this.inputStream = new ByteArrayInputStream(json.getBytes());
			
		}
		return "stream-json";
	}
	public String findById(){
		Integer empno = null;
		if(this.emp!=null){
			empno = this.emp.getEmpno();
		}
		if(empno!=null){
			this.emp = this.empService.findEmpById(empno);
		}
		return "json";
	}
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
