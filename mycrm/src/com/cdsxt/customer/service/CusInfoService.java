package com.cdsxt.customer.service;

import java.util.List;

import com.cdsxt.customer.po.CrmCustomer;

public interface CusInfoService {
	List<CrmCustomer> findAllCustomer();
	void addCustomer(CrmCustomer c);
	void deleCustomer(Integer i);
	void updateCustomer(Integer cusId, CrmCustomer crmCustomer);
	List<String> findAllCrmCusAreaNames();
	List<String> findAllLevelName();
	List<String> findAllLinkmanNames();
	CrmCustomer findCusDetailInfo(Integer cusId);
}
