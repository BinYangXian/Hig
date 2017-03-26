package com.cdsxt.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibUtil {
	
	private static final ThreadLocal<Session> local = new ThreadLocal<>();
	
	private static SessionFactory factory;

	static {
		
		//获取配置信息
		Configuration configuration = new Configuration().configure();
		//创建一个ServiceRegistry的实例
		//首先回去其标准的建造器  用建造者模式进行构建对象
		//创建一个标准的建造器
		StandardServiceRegistryBuilder ssb = new StandardServiceRegistryBuilder();
		//得到ServiceRegistry的实例   一定要传如configuration.getProperties()
		ServiceRegistry registry = ssb.applySettings(configuration.getProperties()).build();
		//得到 session工厂   一个数据库对应一个SessionFactory
		factory = configuration.buildSessionFactory(registry);
	}
	
	
	public static Session getSession(){
		Session session = local.get();
		if(session==null || !session.isOpen()){
			local.set(factory.openSession());
		}
		return local.get();
	}
	
	public static void main(String[] args) {
		System.out.println(getSession());
		System.out.println(getSession());
		System.out.println(factory.openSession());
	}
}
