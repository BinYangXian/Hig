package com.cdsxt.service.impl;

import java.util.List;

import com.cdsxt.dao.CompanyDao;
import com.cdsxt.dao.impl.CompanyDaoImpl;
import com.cdsxt.po.Company;
import com.cdsxt.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

	private CompanyDao companyDao = new CompanyDaoImpl();
	
	@Override
	public List<Company> findByParentId(Integer parent) {
		return this.companyDao.findByParentId(parent);
	}

	@Override
	public Company findById(Integer id) {
		return this.companyDao.findById(id);
	}

	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return this.companyDao.findAll();
	}

}
