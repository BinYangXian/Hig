package com.cdsxt.sell.service;

import java.util.List;

import com.cdsxt.sell.po.DevCustom;

public interface DevcustomService {

	List<DevCustom> findFroPage(Integer start, Integer row);

	int findCount();
	
}
