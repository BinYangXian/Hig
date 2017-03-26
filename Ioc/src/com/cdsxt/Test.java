package com.cdsxt;

import com.cdsxt.action.UsersAction;
import com.cdsxt.ioc.IocContainer;

public class Test {
	
	public static void main(String[] args) {
//		UsersAction action = new UsersAction();
//		action.delete();
		
		Object o = IocContainer.getInstance().getBean("usersAction");
		UsersAction action = (UsersAction)o;
		System.out.println(o);
		action.delete();
	}

}
