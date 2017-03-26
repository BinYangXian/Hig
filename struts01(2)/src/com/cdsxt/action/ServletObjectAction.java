package com.cdsxt.action;

import org.apache.struts2.ServletActionContext;

public class ServletObjectAction {

	
	public String execute(){
		//得到原生对象  用ServletActionContext 类去得到
		
		ServletActionContext.getRequest().setAttribute("username", "zhangsan");
		
		return "test";
	}
}
