package com.cdsxt.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.customer.dao.CusInfoDao;
import com.cdsxt.customer.po.CrmCustomer;
import com.cdsxt.customer.service.CusInfoService;
@Service
@Transactional(readOnly=true)
public class CusInfoServiceImpl implements CusInfoService{
	@Autowired
	private CusInfoDao cusInfoDao;
	@Override
	public List<CrmCustomer> findAllCustomer() {
		return this.cusInfoDao.findAllCustomer();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void addCustomer(CrmCustomer c) {
		this.cusInfoDao.addCustomer(c);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void deleCustomer(Integer i) {
		this.cusInfoDao.deleCustomer(i);
		
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void updateCustomer(Integer cusId, CrmCustomer crmCustomer) {
		this.cusInfoDao.updateCustomer(cusId,crmCustomer);
		
	}

	@Override
	public List<String> findAllCrmCusAreaNames() {
		return this.cusInfoDao.findAllCrmCusAreaNames();
	}

	@Override
	public List<String> findAllLevelName() {
		return this.cusInfoDao.findAllLevelName();
	}

	@Override
	public List<String> findAllLinkmanNames() {
		return this.cusInfoDao.findAllLinkmanNames();
	}
	@Override
	public CrmCustomer findCusDetailInfo(Integer cusId) {
		return this.cusInfoDao.findCusDetailInfo(cusId);
	}



}
