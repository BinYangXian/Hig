package com.cdsxt.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.cdsxt.po.ClassInfo;
import com.cdsxt.po.Husband;
import com.cdsxt.po.Student;
import com.cdsxt.po.Wife;
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
		
		info.setStudent(s1);
		
		Session session = HibUtil.getSession();
		session.beginTransaction();
		
		
		//保存数据
		session.save(s1);
		session.save(info);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testUpdate(){
		Session session = HibUtil.getSession();
		ClassInfo info = (ClassInfo) session.get(ClassInfo.class,8);
	
		Student s1 = new Student();
		s1.setStuName("王五");
		
		s1.setInfo(info);
		
		session.beginTransaction();
		
		session.save(s1);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@Test
	public void testSave1(){
		Session session = HibUtil.getSession();
	
		Husband husband = new Husband();
		husband.setHname("zhangsan");
		
		Wife wife = new Wife();
		wife.setWname("lisi");
		
		husband.setWife(wife);
		wife.setHusband(husband);
		
		
		session.beginTransaction();
		
		session.save(husband);
		session.save(wife);
		
		session.getTransaction().commit();
		session.close();
	}
	

}
