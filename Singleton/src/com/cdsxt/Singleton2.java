package com.cdsxt;

//饿汉式
public class Singleton2 {
	
	//初始化的问题  效率问题
	private static Singleton2 instance = new Singleton2();
	
	private Singleton2(){};
	
	/**
	 * 理解线程同步的问题
	 * 
	 */
	public static Singleton2 getInstance(){
		return instance;
	}

}
