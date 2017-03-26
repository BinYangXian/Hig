package com.cdsxt.abs.factory;

import com.cdsxt.abs.product.BlackFaleMan;
import com.cdsxt.abs.product.BlackMan;
import com.cdsxt.abs.product.Human;

public class BlackHumanFactory implements Factory{

	@Override
	public Human getMan() {
		return new BlackMan();
	}

	@Override
	public Human getFaleMan() {
		return new BlackFaleMan();
	}

}
