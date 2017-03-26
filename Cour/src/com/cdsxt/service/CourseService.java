package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Course;

public interface CourseService {

	void save(Course course);
	List<Course> findAll();
}
