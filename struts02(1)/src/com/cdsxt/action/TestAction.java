package com.cdsxt.action;

public class TestAction {
	
	private String username;
	
	public void index(){
		System.out.println(this.username);
		System.out.println("TestAction.index()");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
