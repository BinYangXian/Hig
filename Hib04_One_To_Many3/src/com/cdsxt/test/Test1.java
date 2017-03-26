package com.cdsxt.test;

import java.util.Set;

import org.hibernate.Session;

import com.cdsxt.po.ClassInfo;
import com.cdsxt.po.Student;
import com.cdsxt.utils.HibUtil;

public class Test1 {
	
	public static void main(String[] args) {
		Session session = HibUtil.getSession();
		//得到班级
		ClassInfo info = (ClassInfo) session.get(ClassInfo.class, 2);
		
		Set<Student> ss = info.getStudents();
		
		for(Student s:ss){
			System.out.println(s.getStuName());
		}
		session.close();
	}

}
