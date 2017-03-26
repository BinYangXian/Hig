package com.cdsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdsxt.action.UsersAction;

public class BeansTests {
	
	public static void main(String[] args) {
		
		//bean的作用域
		
		//prototype  多例
		//singleton  单例的  默认值
		
		//request    请求
		//session    一次会话
		//globalSession  Application
		//用一个工厂 ApplicationContext
		String [] conf = new String[]{
			"classpath:applicationContext.xml"
		};
		ApplicationContext context = new ClassPathXmlApplicationContext(conf);
		Object o = context.getBean("ua");
		UsersAction action = (UsersAction)o;
		action.delete();
		
		System.out.println(context.getBean("dataSource"));
		System.out.println(context.getBean("dataSource"));
		
	}

}
