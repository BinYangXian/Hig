package com.cdsxt.dao;

import java.util.List;

import com.cdsxt.po.Company;

public interface CompanyDao {

	//每次查询的时候  都根据给定的父id去查询
	List<Company> findByParentId(Integer parent);
	
	Company findById(Integer id);

	List<Company> findAll();
	
}
