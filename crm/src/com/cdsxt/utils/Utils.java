package com.cdsxt.utils;

public class Utils {
	
	//计算权限
	public boolean permission(Integer powerCode,Integer code){
		System.out.println(powerCode+"\t"+code);
		if(powerCode==null || code==null){
			return false;
		}
		
		return (powerCode&code)==code;
	}
	
}
