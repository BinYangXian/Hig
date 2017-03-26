package com.cdsxt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdsxt.action.UsersAction;

public class Test {
	
	public static void main(String[] args) {
//		UsersAction action = new UsersAction();
//		action.delete();
		String[] config={"beans.xml"};
		//通过配置文件，生成相应的容器
		ApplicationContext context=new ClassPathXmlApplicationContext(config);
		Object o = context.getBean("usersAction");
		UsersAction action = (UsersAction)o;
		System.out.println(o);
		action.save();
	}

}
