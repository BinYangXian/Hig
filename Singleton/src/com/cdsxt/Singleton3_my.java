package com.cdsxt;

public class Singleton3_my {
//	private Singleton3_my instance;
	private Singleton3_my(){
	}
	private static class Singleton{
		private static Singleton3_my instance=new Singleton3_my();
	}
	public Singleton3_my getInstance(){
		return Singleton.instance;
	}
}
