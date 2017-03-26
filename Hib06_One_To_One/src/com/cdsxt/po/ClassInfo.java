package com.cdsxt.po;

/**
 * 一方
 * @author Administrator
 *
 */
public class ClassInfo {
	
	private Integer cid;
	private String cname;
	private Student student;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
