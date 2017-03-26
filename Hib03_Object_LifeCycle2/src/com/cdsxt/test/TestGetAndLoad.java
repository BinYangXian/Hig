package com.cdsxt.test;

import org.hibernate.Session;

import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;

/**
 * Get && Load 的区别
 * 
 * 共同点  都是根据id去获取数据
 * 
 * 不同点：
 * 		get 根据id去得到数据  首先会去Session(一级缓存)中查找数据  如果有 直接返回使用  否则
 * 			去SessionFactory(二级缓存)中查找数据  如果有 则直接返回使用  否则
 * 			去数据库中查询数据  如果 没有  直接返回 null  否则 返回对象  并且将对象放入到Session中 如果配置了
 * 			二级缓存  并且有相应的存储策略 则会将对象放入到二级缓存中。
 * 
 * 
 * 		load: Hibernate 会认为给定的id所对应的数据 是一定存在的  返回代理对象  
 * 			    
 * 
 * 			    查找方式：根据id去得到数据  首先会去Session(一级缓存)中查找数据  如果有 直接返回使用  否则
 * 					   1）、判断class上面的lazy属性 如果lazy为true  则直接返回代理对象  当第一次使
 * 						      用到该对的属性的时候  回去  二级缓存中查找数据 如果有 直接返回使用 否则 触发sql语句
 * 						      查询数据 如果没有  则直接报错 ObjectNotFoundException
 * 					   2)、 lazy="false" 和Get方式类似  但是 在数据库中没有数据的时候  会报错 而不是返回null
 * 					   
 * 			
 */
public class TestGetAndLoad {
	
	public static void main(String[] args) {
		
//		testGet();
//		testLoad();
//		testGetReturnProxyObject();
		testLoadReturnInstance();
	}
	
	public static void testGet(){
		//测试get方式
		// 
		Session session = HibUtil.getSession();
		
		
		Emp emp = (Emp) session.get(Emp.class, 7777);
		System.out.println(emp);
		
		
		emp = (Emp) session.get(Emp.class, 7839);
		System.out.println(emp);
		emp = (Emp) session.get(Emp.class, 78390);
		System.out.println(emp);
		session.close();
	}
	
	public static void testLoad(){
		//测试load
		Session session = HibUtil.getSession();
		Emp emp = (Emp) session.load(Emp.class, 7777);
		//System.out.println(emp);
		//System.out.println(emp.getClass());
		emp = (Emp) session.load(Emp.class, 77777);
		//System.out.println(emp.getEname());
		
		session.close();
	}
	
	public static void testGetReturnProxyObject(){
		//测试Get方式返回代理对象
		Session session = HibUtil.getSession();
		
		Emp emp =  (Emp) session.load(Emp.class, 7777);
		System.out.println(emp.getClass());
		
		emp = (Emp) session.get(Emp.class, 7777);
		System.out.println(emp.getClass());
		
		session.close();
	}
	public static void testLoadReturnInstance(){
		//测试load方式返回实例
		Session session = HibUtil.getSession();
		
		Emp emp =  (Emp) session.get(Emp.class, 7777);
		System.out.println(emp.getClass());
		
		emp = (Emp) session.load(Emp.class, 7777);
		System.out.println(emp.getClass());
		
		session.close();
	}

}
