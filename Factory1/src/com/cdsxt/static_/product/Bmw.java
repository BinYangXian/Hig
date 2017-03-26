package com.cdsxt.static_.product;

public class Bmw implements Car{

	@Override
	public void run() {
		System.out.println("开宝马车啦");
	}

	@Override
	public void color() {
		System.out.println("红色");
	}

	@Override
	public void brand() {
		System.out.println("宝马");
	}

}
