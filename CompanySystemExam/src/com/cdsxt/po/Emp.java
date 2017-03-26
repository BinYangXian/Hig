package com.cdsxt.po;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.ManyToAny;

//多方
@Entity
@Table
public class Emp {
	@Id
	@SequenceGenerator(name="seqEmp",sequenceName="seq_emp")
	@GeneratedValue(generator="seqEmp")
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Date hiredate;
	private Double comm;
	
	//作为多方
	@ManyToOne
	@JoinColumn(name="mgr")
	private Emp mgr;
	//作为一方
	@OneToMany(mappedBy="emps")
	private Set<Emp> emps;
	@ManyToOne
	@JoinColumn(name="deptno")
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
		return mgr;
	}
	public void setManager(Emp mgr) {
		this.mgr = mgr;
	}
//	@JSON(serialize=false)
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
//	@JSON(serialize=false)
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
