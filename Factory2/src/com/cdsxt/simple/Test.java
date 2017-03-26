package com.cdsxt.simple;

import com.cdsxt.simple.factory.BlackHumanFactory;
import com.cdsxt.simple.factory.Factory;
import com.cdsxt.simple.factory.WhiteHumanFactory;
import com.cdsxt.simple.factory.YellowHuamnFactory;
import com.cdsxt.simple.product.Human;

public class Test {
	
	public static void main(String[] args) {
//		Factory factory = new BlackHumanFactory();
//		Factory factory = new YellowHuamnFactory();
		Factory factory = new WhiteHumanFactory();
		
		Human human = factory.getHuman();
		
		human.say();
		human.color();
	}

}
