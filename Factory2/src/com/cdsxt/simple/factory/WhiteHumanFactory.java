package com.cdsxt.simple.factory;

import com.cdsxt.simple.product.Human;
import com.cdsxt.simple.product.WhiteHuman;

public class WhiteHumanFactory extends Factory {

	@Override
	public Human getHuman() {
		return new WhiteHuman();
	}

}
