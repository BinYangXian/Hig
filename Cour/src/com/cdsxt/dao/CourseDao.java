package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Course;

public interface CourseDao {

	void save(Course course);
	List<Course> findAll();
	
	List<Course> findByIds(Integer[] ids);
}
