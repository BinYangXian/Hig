package com.cdsxt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.cdsxt.po.Dept;

public class DeptTests {

	public static void main(String[] args) {
		//获取配置信息
		Configuration configuration = new Configuration().configure();
		//创建一个ServiceRegistry的实例
		//首先回去其标准的建造器  用建造者模式进行构建对象
		//创建一个标准的建造器
		StandardServiceRegistryBuilder ssb = new StandardServiceRegistryBuilder();
		//得到ServiceRegistry的实例   一定要传如configuration.getProperties()
		ServiceRegistry registry = ssb.applySettings(configuration.getProperties()).build();
		//得到 session工厂   一个数据库对应一个SessionFactory
		SessionFactory factory = configuration.buildSessionFactory(registry);
		
		//创建一个对象
		Dept dept = new Dept();
		dept.setDeptno(77);
		dept.setDname("77");
		//得到session
		Session session = factory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//执行保存
		session.save(dept);
		//提交事务
		transaction.commit();
		
		
		
		//开启事务
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
		
		session.close();
		
	}
}
