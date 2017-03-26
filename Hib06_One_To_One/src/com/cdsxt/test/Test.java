package com.cdsxt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdsxt.po.ClassInfo;
import com.cdsxt.po.Husband;
import com.cdsxt.po.Student;
import com.cdsxt.po.Wife;
import com.cdsxt.utils.HibUtil;

public class Test {
	
	@org.junit.Test
	public void testSave(){
		Session session = HibUtil.getSession();
		
		ClassInfo info = new ClassInfo();
		info.setCname("Java");
		
		Student s = new Student();
		s.setStuName("admin");
		
		info.setStudent(s);
		s.setInfo(info);
		
		Transaction tx = session.beginTransaction();
		
		session.save(info); //先保存主表（不含外键的，sql的效率要高些）
		session.save(s);//如果没有上句话，在保持s的时候会引用瞬时态的对象，所以会单独保存失败，当然也可以使
		//Student.hbm.xml中的cascade="all"，但是工作中一般不这样使用，而是加上上句话一起保存。
		
		
		tx.commit();
		
		session.close();
		
		
	}
	
	@org.junit.Test
	public void testSave1(){
		Session session = HibUtil.getSession();
		
		ClassInfo info = (ClassInfo) session.get(ClassInfo.class, 22);
		
		Student s = new Student();
		s.setStuName("admin1");

		s.setInfo(info);
		
		Transaction tx = session.beginTransaction();
		session.save(s);
		tx.commit();
		
		session.close();
	}
	
	@org.junit.Test
	public void testSaveHusbandAndWife(){
		Session session = HibUtil.getSession();
		
		Husband husband = new Husband();
		husband.setHname("梁山伯");
		
		Wife wife = new Wife();
		
		wife.setWname("祝英台");
		wife.setHusband(husband);
		husband.setWife(wife);
		
		Transaction tx = session.beginTransaction();
		session.save(husband); //随便先保存哪个。
		session.save(wife);
		
		tx.commit();
		
		session.close();
	}

}
