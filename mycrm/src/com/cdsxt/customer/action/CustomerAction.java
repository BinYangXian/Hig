package com.cdsxt.customer.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.customer.po.CrmCustomer;
import com.cdsxt.customer.po.CusContactLog;
import com.cdsxt.customer.po.CusLinkman;
import com.cdsxt.customer.po.HistoryOrder;
import com.cdsxt.customer.service.CusInfoService;
@Controller
@Scope("prototype")
public class CustomerAction {
	private CrmCustomer crmCustomer;
	private CusLinkman cusLinkman ;
	private CusContactLog contactLog ;
	private HistoryOrder historyOrder ;
	private List<CrmCustomer> crmCustomers ;
	@Autowired
	private CusInfoService cusInfoService;
	private String findAllCustomer(){
		this.crmCustomers=this.cusInfoService.findAllCustomer();
		return "findAll";
	}
	private String addCustomer(){
		if(crmCustomer!=null){
			this.cusInfoService.addCustomer(crmCustomer);
		}
		return "findAll";
	}
	private String deleCustomer(){
		this.cusInfoService.deleCustomer(crmCustomer.getCusId());
		return "findAll";
	}
	private String saveCustomer(){
		this.cusInfoService.updateCustomer(crmCustomer.getCusId(),crmCustomer);
		return "findAll";
	}
	public CrmCustomer getCrmCustomer() {
		return crmCustomer;
	}
	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}
	public CusLinkman getCusLinkman() {
		return cusLinkman;
	}
	public void setCusLinkman(CusLinkman cusLinkman) {
		this.cusLinkman = cusLinkman;
	}
	public CusContactLog getContactLog() {
		return contactLog;
	}
	public void setContactLog(CusContactLog contactLog) {
		this.contactLog = contactLog;
	}
	public HistoryOrder getHistoryOrder() {
		return historyOrder;
	}
	public void setHistoryOrder(HistoryOrder historyOrder) {
		this.historyOrder = historyOrder;
	}
	
	
	
}
