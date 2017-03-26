package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.po.Course;
import com.cdsxt.service.CourseService;
@Service
@Transactional(readOnly=true)
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseDao courseDaoImpl;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addCourse(Course c) {
		this.courseDaoImpl.addCourse(c);
	}

	@Override
	public List<Course> findAll() {
		return this.courseDaoImpl.findAll();
	}

}
