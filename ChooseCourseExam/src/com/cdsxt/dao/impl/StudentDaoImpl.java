package com.cdsxt.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
@Repository

public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Autowired
	private CourseDao courseDao;
	@Override
	public void addStudent(Student student) {
		this.getSession().save(student);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		Query query =this.getSession().createQuery("from Student s");
		return query.list();
	}

	@Override
	public Integer[] findAllCourseByStuId(Integer id) {
//		Query query =this.getSession().createQuery("from Student s where s.stuId=:id");
//		query.setParameter("id", id);
		Student student = (Student)this.getSession().get(Student.class, id);
		Set<Course> courses=student.getCourses();
		Iterator<Course> iterator = courses.iterator();
		Integer[] coursesId=new Integer[courses.size()];
		int i=0;
		while(iterator.hasNext()){
			coursesId[i]=iterator.next().getCid();
			i++;
		}
		System.out.println("coursesId="+coursesId);
		return coursesId;
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void update(Student student) {
		this.getSession().update(student);
	}
	
	@Override
	public Student findByStuId(Integer id) {
		return (Student) this.getSession().get(Student.class, id);
	}
	@Override
	public void updateChoose(Integer stuId, Integer[] ids) {
		Set set = new HashSet();
		for (int i = 0; i < ids.length; i++) {
			Course c=courseDao.findByCid(ids[i]);
			set.add(c);
		}
		
		Student s=findByStuId(stuId);
		Set<Course> courses = s.getCourses();
		courses.clear();
		courses.addAll(set);
		this.getSession().update(s);
	}

}
