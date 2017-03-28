package com.cdsxt.customer.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.customer.po.CrmCusArea;
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
	private List<String> crmCusAreaNames;
	private List<String> areaNames;
	private List<String> linkmanNames;
	
	public List<CrmCustomer> getCrmCustomers() {
		return crmCustomers;
	}
	public void setCrmCustomers(List<CrmCustomer> crmCustomers) {
		this.crmCustomers = crmCustomers;
	}
	public List<String> getLinkmanNames() {
		return linkmanNames;
	}
	public void setLinkmanNames(List<String> linkmanNames) {
		this.linkmanNames = linkmanNames;
	}
	public List<String> getAreaNames() {
		return areaNames;
	}
	public void setAreaNames(List<String> areaNames) {
		this.areaNames = areaNames;
	}
	public List<String> getCrmCusAreaNames() {
		return crmCusAreaNames;
	}
	public void setCrmCusAreaNames(List<String> crmCusAreaNames) {
		this.crmCusAreaNames = crmCusAreaNames;
	}
	@Autowired
	private CusInfoService cusInfoService;
	public String findAll(){
		this.crmCustomers=this.cusInfoService.findAllCustomer();
		return "findAll";
	}
	public String findAllSelectionInfo(){
		this.crmCusAreaNames=this.cusInfoService.findAllCrmCusAreaNames();
		this.areaNames=this.cusInfoService.findAllLevelName();
		this.linkmanNames=this.cusInfoService.findAllLinkmanNames();
		return "findAllSelectionInfo";
	}
	public String addCustomer(){
		if(crmCustomer!=null){
			this.cusInfoService.addCustomer(crmCustomer);
		}
		return "findAll";
	}
	public String deleCustomer(){
		this.cusInfoService.deleCustomer(crmCustomer.getCusId());
		return "findAll";
	}
	public String saveCustomer(){
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
