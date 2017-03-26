package com.cdsxt.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//中间表
@Entity
@Table(name="test_student_course")
public class StudentCourse {

	@Id
	@SequenceGenerator(name="seqSc",sequenceName="seq_test_student_course")
	@GeneratedValue(generator="seqSc")
	private Integer scid;
	//多方
	@ManyToOne
	@JoinColumn(name="stu_id")
	private Student student;
	//多方
	@ManyToOne
	@JoinColumn(name="cid")
	private Course course;
	
	private Integer score;
	public Integer getScid() {
		return scid;
	}
	public void setScid(Integer scid) {
		this.scid = scid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
