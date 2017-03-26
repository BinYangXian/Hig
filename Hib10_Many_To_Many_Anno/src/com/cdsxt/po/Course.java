package com.cdsxt.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test_course")
public class Course {
	
	@Id
	@SequenceGenerator(name="seqCourse",sequenceName="seq_test_course")
	@GeneratedValue(generator="seqCourse")
	private Integer cid;
	private String cname;
	
	//一方  放弃关系维护
	@OneToMany(mappedBy="course")
	private Set<StudentCourse> studentCourses = new HashSet<>(0);

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

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	

}
