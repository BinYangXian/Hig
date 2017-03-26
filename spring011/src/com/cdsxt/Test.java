package com.cdsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdsxt.action.UsersAction;

public class Test {
	
	public static void main(String[] args) {
		//用一个工厂 ApplicationContext
		String [] conf = new String[]{
			"beans.xml"
		};
		ApplicationContext context = new ClassPathXmlApplicationContext(conf);
		Object o = context.getBean("usersAction");
		UsersAction action = (UsersAction)o;
		System.out.println(o);
		action.delete();
	}

}
