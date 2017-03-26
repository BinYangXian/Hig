package com.cdsxt.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity  //表示需要进行持久化管理
@Table(name="test_student")
public class Student {
	
	@Id  //手动指定
	@SequenceGenerator(name="seqStudent",sequenceName="seq_test_student")
	@GeneratedValue(generator="seqStudent")
	@Column(name="stu_id")
	private Integer stuId;
	
	@Column(name="stu_name",length=100,nullable=false,unique=true)
	private String stuName;

	/**
	 * <many-to-one class="" name="" column="">
	 * 
	 * 
	 */
	@ManyToOne
	@JoinColumn(name="cid",unique=true)
	private ClassInfo info;

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public ClassInfo getInfo() {
		return info;
	}

	public void setInfo(ClassInfo info) {
		this.info = info;
	}

}
