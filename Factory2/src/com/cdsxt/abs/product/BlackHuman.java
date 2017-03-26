package com.cdsxt.abs.product;

public abstract class BlackHuman implements Human {

	@Override
	public void color() {
		System.out.println("黑人是黑色的");
	}

	@Override
	public void say() {
		System.out.println("黑人说黑话");
	}

}
