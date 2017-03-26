package com.cdsxt.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {
	/**
	 * 
	 * 单元测试
	 * 
	 * @After()
	 * @Before()
	 * @Test()
	 */
	
	@Before
	public void before(){
		System.out.println("TestJunit.before()");
	}
	
	@After
	public void after(){
		System.out.println("TestJunit.after()");
	}
	
	@Test
	public void test(){
		System.out.println("TestJunit.test()");
	}
	@Test
	public void test1(){
		System.out.println("TestJunit.test1()");
	}
	@Test
	public void test2(){
		System.out.println("TestJunit.test2()");
	}

}
