package com.cdsxt.abs;

import com.cdsxt.abs.factory.BlackHumanFactory;
import com.cdsxt.abs.factory.Factory;
import com.cdsxt.abs.product.Human;

public class Test {
	
	public static void main(String[] args) {
		Factory factory = new BlackHumanFactory();
		
		Human man = factory.getFaleMan();
		
		man.color();
		man.say();
		man.sex();
	}

}
