package com.cdsxt.simple.factory;

import com.cdsxt.simple.product.Human;
import com.cdsxt.simple.product.YellowHuman;

public class YellowHuamnFactory extends Factory {

	@Override
	public Human getHuman() {
		return new YellowHuman();
	}

}
