package com.cdsxt.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test_teacher")
public class Teacher {
	
	@Id
	@SequenceGenerator(name="seqTeacher",sequenceName="seq_test_teacher")
	@GeneratedValue(generator="seqTeacher")
	private Integer tid;
	private String tname;
	
	/**
	 * <set name="" [inverse=""] table="">
	 * 	<key column=""></key>
	 *  <many-to-many class="" column=""></many-to-many>
	 * </set>
	 * 
	 */
	@ManyToMany(mappedBy="teachers")
	private Set<Student> students = new HashSet<>(0);

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
