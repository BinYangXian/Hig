package com.cdsxt.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="test_class_info")
public class ClassInfo {
	
	@Id
	@SequenceGenerator(name="seqInfo",sequenceName="seq_test_class_info")
	@GeneratedValue(generator="seqInfo")
	private Integer cid;
	
	private String cname;
	
	@Transient //表示临时的
	private Integer cno;
	
	@OneToOne(mappedBy="info")
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

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
