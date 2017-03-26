package com.cdsxt.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class LoginAction {
	
	private String username;
	private String password;
	private String msg;
	
	public String login(){
		
		if("admin".equals(username) && "admin".equals(password)){
			return "main";
		}
		this.msg = "用户名或密码错误,请重试!";
		return "login";
	}
	
	public String logout(){
		//强制失效
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
