package com.cdsxt.service.impl;

import java.util.List;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.dao.impl.CourseDaoImpl;
import com.cdsxt.po.Course;
import com.cdsxt.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
	private CourseDao courseDao = new CourseDaoImpl();

	@Override
	public void save(Course course) {
		this.courseDao.save(course);
	}

	@Override
	public List<Course> findAll() {
		return this.courseDao.findAll();
	}

}
