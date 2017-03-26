package com.cdsxt.action;

public class IndexAction {

	/**
	 * 返回值类型  void  String  
	 * 方法没有参数
	 * 
	 * 
	 */
	public void execute(){
		System.out.println("IndexAction.execute()");
	}
	
	public String test(){
		System.out.println("IndexAction.test()");
		return "test";
	}
}
