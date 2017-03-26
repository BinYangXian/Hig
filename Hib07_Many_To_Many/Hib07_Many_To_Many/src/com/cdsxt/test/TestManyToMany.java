package com.cdsxt.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
import com.cdsxt.po.StudentCourse;
import com.cdsxt.po.Teacher;
import com.cdsxt.utils.HibUtil;

public class TestManyToMany {
	
	@Test
	public void testSave(){
		
		/**
		 * 对数据进行操作的时候  先操作放弃关系维护的那一方
		 * 
		 * 将放弃关系维护的那一方  放入到 关系维护的那一方
		 * 
		 * 然后保存  先保存 放弃关系维护的那一方 
		 * 再保存  关系维护的那一方
		 * 
		 * 放弃关系维护的那一方的set集合  只是用于查询数据  不会用于 建立联系或者维护关系
		 * 
		 */
		Teacher t = new Teacher();
		t.setTname("张三");
		
		
		Student student = new Student();
		student.setStuName("李四");

		Set<Teacher> tt = new HashSet<>();
		tt.add(t);
		
		student.setTeachers(tt);
		
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.save(t);
		session.save(student);
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	public void testFind(){
		Session session = HibUtil.getSession();
		Teacher teacher = (Teacher) session.get(Teacher.class, 2);
		System.out.println(teacher.getStudents().size());
		session.close();
	}


	@Test
	public void testUpdate(){
		Session session = HibUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		Student s = (Student) session.get(Student.class, 2);
		
		//修改对应关系
		// 第一种  将要移除的数据 从得到的对象的集合中移除掉  然后更新回去
		// 第二种  将原有的关系全部断开  在加入新的对象  然后更新对象即可
		
		Set<Teacher> ts = s.getTeachers();
		if(ts==null){
			ts = new HashSet<>();
		}
		
		ts.clear();
		
		Teacher t = (Teacher) session.get(Teacher.class, 3);
		
		ts.add(t);
		
		s.setTeachers(ts);
		session.update(s);
		
		
		tx.commit();
		
		session.close();
		
		
	}
	
	
	@Test
	public void testSaveCourse(){
		Session session = HibUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		//保存课程
		
		Course course = new Course();
		course.setCname("Java");
		session.save(course);
		//模拟选课
		
		//修改分数
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void testSaveStudent(){
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		Student s = new Student();
		s.setStuName("王五");
		
		Teacher teacher = (Teacher) session.get(Teacher.class, 1);
		Set<Teacher> ts = new HashSet<>();
		ts.add(teacher);
		
		s.setTeachers(ts);
		
		session.save(s);
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	public void testChooseCourse(){
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//查询学生
		Student s1 = (Student) session.get(Student.class, 1);
		Student s2 = (Student) session.get(Student.class, 2);
		
		//查询课程
		
		Course course = (Course) session.get(Course.class, 1);
		//创建中间表的对象
		StudentCourse sc1 = new StudentCourse();
		StudentCourse sc2 = new StudentCourse();
		//设置关系
		sc1.setStudent(s1);
		sc1.setCourse(course);
		
		sc2.setStudent(s2);
		sc2.setCourse(course);
		
		//保存对象
		session.save(sc1);
		session.save(sc2);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testUpdateScore(){
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		//根据学生id和课程id得到唯一中间表记录
		
		Query query = session.createQuery("select sc from StudentCourse sc where sc.student.stuId=? and sc.course.cid=?");
		query.setInteger(0, 1);
		query.setInteger(1, 1);
		List<StudentCourse> scs = query.list();
		StudentCourse sc = scs.get(0);
		
		sc.setScore(88);
		
		session.update(sc);
		
		tx.commit();
		session.close();
	}
}
