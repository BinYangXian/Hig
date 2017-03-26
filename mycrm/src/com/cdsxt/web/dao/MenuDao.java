package com.cdsxt.web.dao;

import java.util.List;

import com.cdsxt.web.po.Menu;

public interface MenuDao {

	List<Menu> findAll();

	Menu findById(Integer id);

}
