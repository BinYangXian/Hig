package com.cdsxt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cdsxt.po.Users;
import com.cdsxt.utils.HibUtil;

public class UsersTest {

	public static void main(String[] args) {
		
		//创建一个对象
		Users user = new Users();
		user.setName("zhangsan");
		user.setAge(18);
		//得到session
		Session session = HibUtil.getSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//执行保存
		session.save(user);
		//提交事务
		transaction.commit();
		session.close();
		
		
	/*	//开启事务
		transaction = session.beginTransaction();
		Dept d = (Dept) session.get(Dept.class, 77);
		d.setDname("test");
		session.update(d);
		//提交事务
		transaction.commit();
		
		//开启事务
//		transaction = session.beginTransaction();
//		d = (Dept) session.get(Dept.class, 77);
//		session.delete(d);
//		transaction.commit();
		
		session.close();*/
		
	}
}
