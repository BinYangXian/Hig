package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Student;

public interface StudentDao {
	
	void save(Student student);
	List<Student> findAll();
	Student findByStuId(Integer id);
	void update(Student student);
	

}
