package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Course;

public interface CourseDao {

	void addCourse(Course course);
	List<Course> findAll();
	Course findByCid(Integer integer);

}
