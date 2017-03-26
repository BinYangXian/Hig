package com.cdsxt.abs.factory;

import com.cdsxt.abs.product.Human;
import com.cdsxt.abs.product.YellowFaleMan;
import com.cdsxt.abs.product.YellowMan;

public class YellowHumanFactory implements Factory {

	@Override
	public Human getMan() {
		return new YellowMan();
	}

	@Override
	public Human getFaleMan() {
		return new YellowFaleMan();
	}

}
