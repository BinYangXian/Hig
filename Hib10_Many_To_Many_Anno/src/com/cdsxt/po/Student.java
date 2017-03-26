package com.cdsxt.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 多方
 *
 */
@Entity
@Table(name="test_student")
public class Student {
	
	@Id
	@SequenceGenerator(name="seqStudent",sequenceName="seq_test_student")
	@GeneratedValue(generator="seqStudent")
	@Column(name="stu_id")
	private Integer stuId;
	@Column(name="stu_name")
	private String stuName;
	private String age;
	private Integer score;
	
	/**
	 * <set name="" [inverse=""] table="">
	 * 	<key column=""></key>
	 *  <many-to-many class="" column=""></many-to-many>
	 * </set>
	 * 
	 */
	@ManyToMany
	@JoinTable(
		name="test_student_teacher",
		joinColumns={
			@JoinColumn(name="stu_id")
		},
		inverseJoinColumns={
			@JoinColumn(name="tid")
		}
	)
	private Set<Teacher> teachers = new HashSet<>(0);
	//一方  放弃关系维护
	@OneToMany(mappedBy="student")
	private Set<StudentCourse> studentCourses = new HashSet<>(0);

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

}
