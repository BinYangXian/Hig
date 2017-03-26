package com.cdsxt;

//静态内部类
public class Singleton3 {
	
	private Singleton3(){};
	
	/**
	 * 理解线程同步的问题
	 * 
	 */
	public static Singleton3 getInstance(){
		return Creator.instance;
	}
	
	private static class Creator{
		private static Singleton3 instance = new Singleton3();
	}

}
