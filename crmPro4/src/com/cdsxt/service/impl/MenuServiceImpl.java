package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.MenuDao;
import com.cdsxt.po.Menu;
import com.cdsxt.service.MenuService;
import com.cdsxt.vo.MenuVo;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> findAll() {
		return this.menuDao.findAll();
	}

	@Override
	public List<MenuVo> findAllToVo() {
		return this.menuDao.findAllToVo();
	}


}
