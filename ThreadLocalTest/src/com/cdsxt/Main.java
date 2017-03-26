package com.cdsxt;

import java.util.HashMap;
import java.util.Map;

public class Main {
	
	/**
	 * 
	 * 测试线程局部变量ThreadLocal
	 * 
	 * 相当于Map<Thread,Object>，下述是其实现原理模拟
	 * 
	 * @param args
	 */
	
	static Local local = new Local();
	
	public static void main(String[] args) {
		
		local.set("aaaaa");
		
		System.out.println(local.get());
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Main.main(...).new Runnable() {...}.run()");
				local.set("bbbbb");
				System.out.println(local.get());
				test();
			}
		}).start();
		
	}
	
	public static void test(){
		System.out.println(local.get());
	}
	
	public static class Local{
		
		Map<Thread,Object> local = new HashMap<>();
		
		public void set(Object value){
			this.local.put(Thread.currentThread(), value);
		}
		
		public Object get(){
			return this.local.get(Thread.currentThread());
		}
		
		public void remove(){
			this.local.remove(Thread.currentThread());
		}
		
	}

}
