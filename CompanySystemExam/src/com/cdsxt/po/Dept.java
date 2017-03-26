package com.cdsxt.po;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



//一方
@Entity
@Table(name = "dept")
public class Dept {
	@Id
	@SequenceGenerator(name="seqDept",sequenceName="seq_dept")
	@GeneratedValue(generator="seqDept")
	private Integer deptno;
	private String dname;
	private String loc;
	@OneToMany(cascade={CascadeType.ALL},mappedBy="dept",fetch=FetchType.EAGER)
	private Set<Emp> emps;
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

}
