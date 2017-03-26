package com.cdsxt.customer.dao;

import java.util.List;

import com.cdsxt.customer.po.CrmCustomer;

public interface CusInfoDao {
	List<CrmCustomer> findAllCustomer();
	void addCustomer(CrmCustomer c);
	void deleCustomer(Integer i);
	void updateCustomer(Integer cusId, CrmCustomer crmCustomer);
}
