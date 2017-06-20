package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Menu;
import com.cdsxt.vo.MenuVo;

public interface MenuDao {

	List<Menu> findAll();
	
	List<MenuVo> findAllToVo();
}
