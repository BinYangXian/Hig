package com.cdsxt.dao;

import java.util.List;
import java.util.Set;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;

public interface StudentDao {
	
	void addStudent(Student student);
	List<Student> findAll();
	Integer[] findAllCourseByStuId(Integer id);
	void update(Student student);
	void updateChoose(Integer stuId, Integer[] ids);
	Student findByStuId(Integer id);
}
