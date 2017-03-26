package com.cdsxt.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.cdsxt.dao.imp.EmpDaoImpl;
import com.cdsxt.po.Emp;
import com.google.gson.Gson;

public class UsersAction {
	
	private EmpDaoImpl empDaoImpl = new EmpDaoImpl();
	
	private List<Emp> emps;
	
	private Emp emp;
	
	private InputStream inputStream;
	
	public String findAll(){
		this.emps = this.empDaoImpl.findAll();
		return "findAll";
	}
	
	public String save(){
		if(this.emp!=null){
			this.empDaoImpl.save(emp);
		}
		return "save-success";
		
	}
	public String update(){
		if(this.emp!=null){
			this.empDaoImpl.update(emp);
		}
		return "save-success";
		
	}
	public String delete(){
		System.out.println(emp.getEmpno());
		if(this.emp.getEmpno()!=null){
			this.empDaoImpl.delete(emp.getEmpno());
		}
		return "save-success";
		
	}
	
	public String findOne(){
		Integer empno = null;
		if(this.emp!=null){
			empno = this.emp.getEmpno();
		}
		if(empno!=null){
			this.emp = this.empDaoImpl.findByEmpno(empno);
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
			this.emp = this.empDaoImpl.findByEmpno(empno);
		}
		return "json";
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
