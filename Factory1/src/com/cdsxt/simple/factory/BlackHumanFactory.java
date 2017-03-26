package com.cdsxt.simple.factory;

import com.cdsxt.simple.product.BlackHuman;
import com.cdsxt.simple.product.Human;

public class BlackHumanFactory extends Factory {

	@Override
	public Human getHuman() {
		return new BlackHuman();
	}

}
