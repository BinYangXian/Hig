package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Student;

public interface StudentService {
	
	void save(Student student);
	List<Student> findAll();
	void choose(Integer id, Integer[] ids);
	Integer[] findAllCourse(Integer id);

}
