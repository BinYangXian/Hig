package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Menu;
import com.cdsxt.vo.MenuVo;

public interface MenuService {

	List<Menu> findAll();
	
	List<MenuVo> findAllToLeft();

	List<Menu> findByIds(Integer[] menuIds);
	
}
