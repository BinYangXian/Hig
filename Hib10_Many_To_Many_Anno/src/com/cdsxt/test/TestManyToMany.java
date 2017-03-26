package com.cdsxt.test;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
import com.cdsxt.po.StudentCourse;
import com.cdsxt.po.Teacher;
import com.cdsxt.utils.HibUtil;

public class TestManyToMany {
	
	private Session session;
	
	@Before
	public void before(){
		this.session = HibUtil.getSession();
		this.session.beginTransaction();
		
	}
	@After
	public void after(){
		this.session.getTransaction().commit();
		this.session.close();
	}
	
	@Test
	public void testSave(){
		Teacher teahcer  = new Teacher();
		teahcer.setTname("老刘");
		
		Student student = new Student();
		student.setStuName("张三");
		
		session.save(teahcer);
		
		
		student.getTeachers().add(teahcer);
		session.save(student);
	}
	
	@Test
	public void testSave1(){
		Course course = new Course();
		course.setCname("Java");
		
		Student s = (Student) this.session.get(Student.class, 1);
		
		//创建中间表记录
		StudentCourse sc = new StudentCourse();
		sc.setCourse(course);
		sc.setStudent(s);
		
		session.save(course);
		session.save(sc);
	}

}
