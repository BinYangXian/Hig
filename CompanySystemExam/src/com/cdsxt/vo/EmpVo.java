package com.cdsxt.vo;

import java.util.Date;

import com.cdsxt.po.Emp;

public class EmpVo {
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Date hiredate;
	private Double comm;
	
	
	public EmpVo(Emp emp) {
		if(emp==null){
			throw new IllegalArgumentException("参数emp不能为空!");
		}
		
		this.empno = emp.getEmpno();
		this.ename = emp.getEname();
		this.job = emp.getJob();
		this.sal = emp.getSal();
		this.hiredate = emp.getHiredate();
		this.comm = emp.getComm();
	}
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
	
	
}
