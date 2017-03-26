package com.cdsxt;

//懒汉式
public class Singleton1 {
	
	private static Singleton1 instance = null;
	
	private Singleton1(){};
	
	/**
	 * 理解线程同步的问题
	 * 
	 */
	public static synchronized Singleton1 getInstance(){
		if(instance==null){
			instance = new Singleton1();
		}
		return instance;
	}

}
