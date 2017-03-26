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
	
	//作为多方
	private String mgr;
	
	private String dept;
	
	public EmpVo(Emp emp){
		
		if(emp==null){
			throw new IllegalArgumentException("参数emp不能为空!");
		}
		
		this.empno = emp.getEmpno();
		this.ename = emp.getEname();
		this.job = emp.getJob();
		this.sal = emp.getSal();
		this.hiredate = emp.getHiredate();
		this.comm = emp.getComm();
		Emp manager = emp.getManager();
		if(manager!=null){
			this.mgr = manager.getEname();
		}
		this.dept = emp.getDept().getDname();
	}
	
	public EmpVo(){}
	
	public EmpVo(Integer empno,String ename){
		this.empno = empno;
		this.ename = ename;
	}
	public EmpVo(Integer empno,String ename,String job){
		this.empno = empno;
		this.ename = ename;
		this.job = job;
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

	public String getMgr() {
		return mgr;
	}

	public void setMgr(String mgr) {
		this.mgr = mgr;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "EmpVo [empno=" + empno + ", ename=" + ename + ", job=" + job + ", sal=" + sal + ", hiredate=" + hiredate
				+ ", comm=" + comm + ", mgr=" + mgr + ", dept=" + dept + "]";
	}

}
