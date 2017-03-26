package com.cdsxt.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
@Repository

public class CourseDaoImpl implements CourseDao {
	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void addCourse(Course course) {
		this.getSession().save(course);
	}

	@PostConstruct
	public void init(){
		System.out.println("CourseDaoImpl.init()");
	}
	@Override
	public List<Course> findAll() {
		Query query = this.getSession().createQuery("from Course c");
		return query.list();
	}

	@Override
	public Course findByCid(Integer cid) {
		return (Course) this.getSession().get(Course.class, cid);
	}



}
