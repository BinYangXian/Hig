package com.cdsxt.web.service;

import java.util.List;

import com.cdsxt.web.po.Menu;
import com.cdsxt.web.po.Role;
import com.cdsxt.web.vo.MenuVo;

public interface MenuService {

	List<MenuVo> findAll(Role role);

	Menu findById(Integer id);

	List<MenuVo> findAllMenu();

	

}
