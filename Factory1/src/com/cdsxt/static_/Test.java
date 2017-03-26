package com.cdsxt.static_;

import com.cdsxt.static_.product.Car;

public class Test {
	
	public static void main(String[] args) {
		Car car = Factory.getCar(2);
		action(car);
		
	}
	
	public static void action(Car car){
		car.brand();
		car.color();
		car.run();
	}

}
