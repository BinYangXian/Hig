package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.RoleDao;
import com.cdsxt.po.Role;
import com.cdsxt.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public Role findById(Integer id) {
		return this.roleDao.findById(id);
	}

	@Override
	public List<Role> findByIds(Integer[] ids) {
		return this.roleDao.findByIds(ids);
	}

	@Override
	public List<Role> findAll() {
		return this.roleDao.findAll();
	}

}
