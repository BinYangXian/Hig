package com.cdsxt.action;

import com.cdsxt.po.Users;

public class ReturnedAction {
	
	private Users users;
	
	public String execute(){
		System.out.println("ReturnedAction.execute()做了一些处理，然后再返回一个‘test’给下一个(在struts中配置的处理单元"
				+ "jsp或者action<-->它们的本质同样是servlet)处理逻辑");
		return "chain";
	}
	public String test(){
		System.out.println("ReturnedAction.test()");
		return "dispatcher";
	}
	public String test1(){
		System.out.println("ReturnedAction.redirect()"); //重定向到页面，地址栏会改变为
		//http://localhost:8080/MyFirStructs21/test.jsp
		return "redirect";
	}
	public String test2(){
		System.out.println("ReturnedAction.redirectAction()");//重定向到action，地址栏会改变为
		//http://localhost:8080/MyFirStructs21/index!execute.action （注意尾缀是 .action，因为没有struts.xml中没有自定义为do：
		//<constant name="struts.action.extension" value="do"></constant>，如果自定义了，尾缀变为 .do）
		return "redirectAction";
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
