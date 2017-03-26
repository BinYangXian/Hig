package com.cdsxt.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdsxt.dao.EmpDao;
import com.cdsxt.dao.impl.EmpDaoImpl;
import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;

public class EmpDaoTests {
	
	public static void main(String[] args) {
//		testFindAll();
		testLifeCycle1();
//		testLifeCycle();
	}
	
	public static void testFindAll(){
		EmpDao empDao = new EmpDaoImpl();
		List<Emp> emps = empDao.findAll();
		System.out.println(emps.size());
	}
	
	public static void testLifeCycle(){
		//测试对象的声明周期
		Emp emp = new Emp();
		emp.setDeptno(20);
		emp.setEmpno(7777);
		emp.setEname("Admin");
		emp.setJob("Java");
		emp.setHiredate(new Date());
		Session session = HibUtil.getSession();
		
		//将对象从瞬时态变化为持久态
		//只要将对象进行save 或者saveOrUpdate 即可
		
		//将持久态变化为游离态(Session[管道])
		//evict 将管道中的对象  直接清除掉  清除指定对象
		//clear 将管道清空  清除管道中的所有对象
		//close 直接将管道给关闭
		
		
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		/**
		 * 如果是在事务管理器中执行了对 持久态对象的修改  该值会同步到数据库中  根本不需要显示调用update方法进行更新
		 * 
		 * 
		 */

//		session.evict(emp);
//		emp.setJob("HTML");
		
		tx.commit();
		
		tx = session.beginTransaction();
		
		emp.setJob("HTML");
		
		tx.commit();
		
		session.close();
		
	}
	
	public static void testLifeCycle1(){
		Session session = HibUtil.getSession();
		
		Emp emp = (Emp) session.get(Emp.class, 7777);
		emp = (Emp) session.load(Emp.class, 7777);
		System.out.println(emp);
		
		session.evict(emp);
		
		Transaction tx = session.beginTransaction();
		
		emp.setJob("Java");
		
		tx.commit();
		
		
		session.close();
	}

}
