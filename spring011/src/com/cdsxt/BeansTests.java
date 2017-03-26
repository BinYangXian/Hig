package com.cdsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansTests {
	
	public static void main(String[] args) {
		//用一个工厂 ApplicationContext
		String [] conf = new String[]{
			"classpath:applicationContext.xml"
		};
		ApplicationContext context = new ClassPathXmlApplicationContext(conf);
		context.getBean("beans");
		System.out.println(context.getBean("testset"));
		System.out.println(context.getBean("dataSource"));
		System.out.println(context.getBean("dataSource1"));
		
	}

}
