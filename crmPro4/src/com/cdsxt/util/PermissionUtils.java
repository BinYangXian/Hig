package com.cdsxt.util;

import org.springframework.stereotype.Component;

@Component("permission")
public class PermissionUtils {

	public boolean hasPermission(Integer powerCode,Integer power){
		if(powerCode == null){
			return false;
		}
		if(power == null){
			return false;
		}
		return (powerCode & power) == power;
	}
}
