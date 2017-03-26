package com.cdsxt.simple.product;

public class YellowHuman implements Human{

	@Override
	public void color() {
		System.out.println("黄人是黄色的");
	}

	@Override
	public void say() {
		System.out.println("黄色说黄话");
	}

}
