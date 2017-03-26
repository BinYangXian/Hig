package com.cdsxt.service;

import java.util.List;
import java.util.Set;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;

public interface StudentService {
	void addStudent(Student s);
	List<Student> findAll();
	Integer[] findAllCourseByStuId(Integer id);
	void update(Student student);
	void choose(Integer integer, Integer[] ids);
	
}
