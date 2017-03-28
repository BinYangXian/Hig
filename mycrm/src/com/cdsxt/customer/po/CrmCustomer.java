package com.cdsxt.customer.po;

import java.io.Serializable;
import javax.persistence.*;

import com.cdsxt.web.po.User;

import java.util.Set;


/**
 * The persistent class for the crm_customer database table.
 * 
 */
@Entity
@Table(name="crm_customer")
public class CrmCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cus_id")
	private int cusId;

	@Column(name="cus_addr")
	private String cusAddr;

	@Column(name="cus_bank")
	private String cusBank;

	@Column(name="cus_bankaccount")
	private String cusBankaccount;

	private String cus_buslicNum;

	@Column(name="cus_credibility")
	private int cusCredibility;

	@Column(name="cus_fax")
	private String cusFax;

	@Column(name="cus_landtax")
	private String cusLandtax;

	@Column(name="cus_legalperson")
	private String cusLegalperson;

	@Column(name="cus_name")
	private String cusName;

	@Column(name="cus_num")
	private String cusNum;

	@Column(name="cus_regiscapital")
	private double cusRegiscapital;

	@Column(name="cus_satisfaction")
	private int cusSatisfaction;

	@Column(name="cus_tax")
	private String cusTax;

	@Column(name="cus_tel")
	private String cusTel;

	@Column(name="cus_turnover")
	private double cusTurnover;

	@Column(name="cus_url")
	private String cusUrl;

	@Column(name="cus_zipcode")
	private int cusZipcode;

	private String remark1;

	private String remark2;

	private String remark3;

	//bi-directional many-to-one association to CrmCusArea
	@ManyToOne
	@JoinColumn(name="area_id")
	private CrmCusArea crmCusArea;

	//bi-directional many-to-one association to CrmCusLevel
	@ManyToOne
	@JoinColumn(name="level_id")
	private CrmCusLevel crmCusLevel;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-one association to CusContactLog
	@OneToMany(mappedBy="crmCustomer")
	private Set<CusContactLog> cusContactLogs;

	//bi-directional many-to-one association to CusLinkman
	@ManyToOne
	@JoinColumn(name="cus_linkman_id")
	private CusLinkman cusLinkman;

	//bi-directional many-to-one association to CusStaMsg
	@OneToMany(mappedBy="crmCustomer")
	private Set<CusStaMsg> cusStaMsgs;

	//bi-directional many-to-one association to HistoryOrder
	@OneToMany(mappedBy="crmCustomer")
	private Set<HistoryOrder> historyOrders;

	public CrmCustomer() {
	}

	public int getCusId() {
		return this.cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusAddr() {
		return this.cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	public String getCusBank() {
		return this.cusBank;
	}

	public void setCusBank(String cusBank) {
		this.cusBank = cusBank;
	}

	public String getCusBankaccount() {
		return this.cusBankaccount;
	}

	public void setCusBankaccount(String cusBankaccount) {
		this.cusBankaccount = cusBankaccount;
	}

	public String getCus_buslicNum() {
		return this.cus_buslicNum;
	}

	public void setCus_buslicNum(String cus_buslicNum) {
		this.cus_buslicNum = cus_buslicNum;
	}

	public int getCusCredibility() {
		return this.cusCredibility;
	}

	public void setCusCredibility(int cusCredibility) {
		this.cusCredibility = cusCredibility;
	}

	public String getCusFax() {
		return this.cusFax;
	}

	public void setCusFax(String cusFax) {
		this.cusFax = cusFax;
	}

	public String getCusLandtax() {
		return this.cusLandtax;
	}

	public void setCusLandtax(String cusLandtax) {
		this.cusLandtax = cusLandtax;
	}

	public String getCusLegalperson() {
		return this.cusLegalperson;
	}

	public void setCusLegalperson(String cusLegalperson) {
		this.cusLegalperson = cusLegalperson;
	}

	public String getCusName() {
		return this.cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusNum() {
		return this.cusNum;
	}

	public void setCusNum(String cusNum) {
		this.cusNum = cusNum;
	}

	public double getCusRegiscapital() {
		return this.cusRegiscapital;
	}

	public void setCusRegiscapital(double cusRegiscapital) {
		this.cusRegiscapital = cusRegiscapital;
	}

	public int getCusSatisfaction() {
		return this.cusSatisfaction;
	}

	public void setCusSatisfaction(int cusSatisfaction) {
		this.cusSatisfaction = cusSatisfaction;
	}

	public String getCusTax() {
		return this.cusTax;
	}

	public void setCusTax(String cusTax) {
		this.cusTax = cusTax;
	}

	public String getCusTel() {
		return this.cusTel;
	}

	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}

	public double getCusTurnover() {
		return this.cusTurnover;
	}

	public void setCusTurnover(double cusTurnover) {
		this.cusTurnover = cusTurnover;
	}

	public String getCusUrl() {
		return this.cusUrl;
	}

	public void setCusUrl(String cusUrl) {
		this.cusUrl = cusUrl;
	}

	public int getCusZipcode() {
		return this.cusZipcode;
	}

	public void setCusZipcode(int cusZipcode) {
		this.cusZipcode = cusZipcode;
	}

	public String getRemark1() {
		return this.remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return this.remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return this.remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public CrmCusArea getCrmCusArea() {
		return this.crmCusArea;
	}

	public void setCrmCusArea(CrmCusArea crmCusArea) {
		this.crmCusArea = crmCusArea;
	}

	public CrmCusLevel getCrmCusLevel() {
		return this.crmCusLevel;
	}

	public void setCrmCusLevel(CrmCusLevel crmCusLevel) {
		this.crmCusLevel = crmCusLevel;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CusContactLog> getCusContactLogs() {
		return this.cusContactLogs;
	}

	public void setCusContactLogs(Set<CusContactLog> cusContactLogs) {
		this.cusContactLogs = cusContactLogs;
	}

	public CusContactLog addCusContactLog(CusContactLog cusContactLog) {
		getCusContactLogs().add(cusContactLog);
		cusContactLog.setCrmCustomer(this);

		return cusContactLog;
	}

	public CusContactLog removeCusContactLog(CusContactLog cusContactLog) {
		getCusContactLogs().remove(cusContactLog);
		cusContactLog.setCrmCustomer(null);

		return cusContactLog;
	}



	public CusLinkman getCusLinkman() {
		return cusLinkman;
	}

	public void setCusLinkman(CusLinkman cusLinkman) {
		this.cusLinkman = cusLinkman;
	}



	public Set<CusStaMsg> getCusStaMsgs() {
		return this.cusStaMsgs;
	}

	public void setCusStaMsgs(Set<CusStaMsg> cusStaMsgs) {
		this.cusStaMsgs = cusStaMsgs;
	}

	public CusStaMsg addCusStaMsg(CusStaMsg cusStaMsg) {
		getCusStaMsgs().add(cusStaMsg);
		cusStaMsg.setCrmCustomer(this);

		return cusStaMsg;
	}

	public CusStaMsg removeCusStaMsg(CusStaMsg cusStaMsg) {
		getCusStaMsgs().remove(cusStaMsg);
		cusStaMsg.setCrmCustomer(null);

		return cusStaMsg;
	}

	public Set<HistoryOrder> getHistoryOrders() {
		return this.historyOrders;
	}

	public void setHistoryOrders(Set<HistoryOrder> historyOrders) {
		this.historyOrders = historyOrders;
	}

	public HistoryOrder addHistoryOrder(HistoryOrder historyOrder) {
		getHistoryOrders().add(historyOrder);
		historyOrder.setCrmCustomer(this);

		return historyOrder;
	}

	public HistoryOrder removeHistoryOrder(HistoryOrder historyOrder) {
		getHistoryOrders().remove(historyOrder);
		historyOrder.setCrmCustomer(null);

		return historyOrder;
	}

}