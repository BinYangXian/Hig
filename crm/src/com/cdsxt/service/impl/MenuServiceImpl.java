package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.MenuDAO;
import com.cdsxt.po.Menu;
import com.cdsxt.service.MenuService;
import com.cdsxt.vo.MenuVo;

@Service
@Transactional(readOnly=true)
public class MenuServiceImpl implements MenuService {

	
	@Autowired
	private MenuDAO menuDAO;
	@Override
	public List<Menu> findAll() {
		return this.menuDAO.findAll();
	}

	@Override
	public List<MenuVo> findAllToLeft() {
		return this.menuDAO.findAllToLeft();
	}

	@Override
	public List<Menu> findByIds(Integer[] menuIds) {
		// TODO Auto-generated method stub
		return menuDAO.findByIds(menuIds);
	}

}
