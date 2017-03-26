package com.cdsxt.static_.product;

public class Benz implements Car{

	@Override
	public void brand() {
		System.out.println("奔驰");
	}

	@Override
	public void run() {
		System.out.println("开奔驰啦");
	}

	@Override
	public void color() {
		System.out.println("银色");
	}

}
