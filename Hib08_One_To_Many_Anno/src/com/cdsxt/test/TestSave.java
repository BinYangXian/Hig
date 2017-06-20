package com.cdsxt.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.cdsxt.po.ClassInfo;
import com.cdsxt.po.Student;
import com.cdsxt.utils.HibUtil;

public class TestSave {
	
	@Test
	public void testSave(){
		
		//测试保存
		ClassInfo info = new ClassInfo();
		info.setCname("Java");
		
		Student s1 = new Student();
		s1.setStuName("张三");
		
		s1.setInfo(info);
		
		Session session = HibUtil.getSession();
		session.beginTransaction();
		
		Set<Student> ss =new HashSet<>();
		ss.add(s1);
		
		
		info.setStudents(ss);
		session.save(info);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testFind(){
		ClassInfo info = (ClassInfo) HibUtil.getSession().createQuery("from ClassInfo").list().get(0);  
		
		Set<Student> ss = info.getStudents();
		
		System.out.println(ss.size());
	}

}
