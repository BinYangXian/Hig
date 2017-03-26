package com.cdsxt.po;

import java.util.Date;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

//多方
public class Emp {
	
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Date hiredate;
	private Double comm;
	
	//作为多方
	private Emp manager;
	//作为一方
	private Set<Emp> emps;
	
	private Dept dept;

	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	//@JSON(serialize=false)
	public Emp getManager() {
		return manager;
	}
	public void setManager(Emp manager) {
		this.manager = manager;
	}
	@JSON(serialize=false)
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	@JSON(serialize=false)
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
