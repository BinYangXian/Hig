package com.cdsxt.po;

import java.util.Set;

/**
 * 一方
 * @author Administrator
 *
 */
public class ClassInfo {
	
	private Integer cid;
	private String cname;
	private Set<Student> students;


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
