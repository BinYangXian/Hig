package com.cdsxt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.cdsxt.po.Dept;
import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;

public class CacheTests {
	
	public static void testCache1() {
		Session session = HibUtil.getSession();
		
		Emp emp  = (Emp) session.get(Emp.class, 7839);
		System.out.println(emp);
		session.close();
		
		emp = null;
		
		session = HibUtil.getSession();
		emp  = (Emp) session.get(Emp.class, 7839);
		System.out.println(emp);
		session.close();
		
		
	}
	
	//测试查询缓存
	public static void testCache2() {
		Session session = HibUtil.getSession();
		List<Dept> depts = session.createQuery("from Dept d").setCacheable(true).list();
		System.out.println(depts.size());
		session.close();
		
		
		session = HibUtil.getSession();
		List<Dept> depts1 = session.createQuery("from Dept d").setCacheable(true).list();
		System.out.println(depts1.size());
		session.close();
		
		
	}
	
	/**
	 * list  查询出来的数据 会放入查询缓存中 ，也可以使用查询缓存  
	 * 
	 * Iterator  不能从查询缓存中读数据  但是 可以将查询出来的数据  放入到缓存中
	 * 
	 * 
	 */
	//测试查询缓存
	public static void testCache3() {
		Session session = HibUtil.getSession();
		Iterator<Dept> depts = session.createQuery("from Dept d").setCacheable(true).iterate();
		while(depts.hasNext()){
			Dept dept = depts.next();
			System.out.println("dept="+dept);
		}
		//System.out.println(depts.hasNext());
		session.close();
		
		
		session = HibUtil.getSession();
		//Iterator<Dept> depts1 = session.createQuery("from Dept d").setCacheable(true).iterate();
		System.out.println("--------------------------------------");
		List<Dept> depts2 = session.createQuery("from Dept d").setCacheable(true).list();
		System.out.println(depts2.size());
		//System.out.println(depts1.hasNext());
		session.close();
		
		
		
	}
	
	public static void main(String[] args) {
		//testCache1();
//		testCache2();
		testCache3();
	}

}
