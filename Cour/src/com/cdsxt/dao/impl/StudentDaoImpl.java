package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Student;
import com.cdsxt.utils.HibUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public void save(Student student) {
		Session session = HibUtil.getSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		Session session = HibUtil.getSession();
		Query query = session.createQuery("select s from Student s");
		return query.list();
	}

	@Override
	public Student findByStuId(Integer id) {
		Session session = HibUtil.getSession();
		return (Student) session.get(Student.class, id);
	}

	@Override
	public void update(Student student) {
		Session session = HibUtil.getSession();
		session.beginTransaction();
		session.update(student);
		session.getTransaction().commit();
	}

}
