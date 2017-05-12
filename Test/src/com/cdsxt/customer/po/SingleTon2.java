package com.cdsxt.customer.po;

//懒汉
public class SingleTon2 {
	private SingleTon2(){
		
	}
	private static SingleTon2 s;
	public static SingleTon2 getSingleTon2(){
		if(s==null){
			s=new SingleTon2();
		}
		return s;
	}
}