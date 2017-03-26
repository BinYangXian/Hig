package com.cdsxt.static_;

import com.cdsxt.static_.product.Benz;
import com.cdsxt.static_.product.Bmw;
import com.cdsxt.static_.product.Car;

public class Factory {

	public static Car getCar(int type){
		if(type==1){
			return new Bmw();
		}else if(type==2){
			return new Benz();
		}else{
			throw new IllegalArgumentException("没有实现相关的产品!");
		}
	}
}
