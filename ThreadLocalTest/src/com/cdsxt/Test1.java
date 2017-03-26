package com.cdsxt;

import com.cdsxt.po.Person;

public class Test1 {
	
	private static final ThreadLocal<Person> local = new ThreadLocal<Person>();
	
	public static void main(String[] args) {
		
		
		Person person = new Person("admin");
		
		System.out.println(person);
		
		local.set(person);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(local.get());
			}
		}).start();
		
		test();
	}
	
	public static void test(){
		System.out.println(local.get());
	}

}
