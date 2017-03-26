package com.cdsxt.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "crm_customer")
public class Customer {
	// 序 号、客户名称、客户编号、地区、客户经理/负责人、客户等级
	@Id
	@SequenceGenerator(name = "seqCusInfo", sequenceName = "seq_crm_customer")
	@GeneratedValue(generator = "seqCusInfo")
	@Column(name = "cus_id")
	private Integer cusId;		//序号
	@Column(name = "cus_name")
	private String cusName;		//客户名称 公司
	@Column(name = "cus_num")
	private String cusNum;		//客户编号
	@Column(name = "cus_addr")
	private String cusAddr;		//客户地址
	@Column(name = "cus_level")
	private Integer cusLevel;	//客户等级
	@Column(name = "cus_satisfaction")
	private Integer cusSatisfaction; //客户满意度
	@Column(name = "cus_credibility")
	private Integer cusCredibility; //客户信用度
	@Column(name = "cus_area")
	private String cusArea; //地区
	@Column(name = "cus_tel")
	private String cusTel;		//电话
	@Column(name = "cus_zipcode")
	private Integer cusZipCode;	//邮编
	@Column(name = "cus_fax")
	private String cusFax;		//传真
	@Column(name = "cus_url")
	private String cusUrl;		//网址
	@Column(name = "cus_buslicNum")
	private String cusBusLicNum;	//营业执照注册号
	@Column(name = "cus_legalperson")
	private String cusLegalPerson;	//法人
	@Column(name = "cus_regiscapital")
	private Double cusRegisCapital;	//注册资金
	@Column(name = "cus_turnover")
	private Double cusTurnover;		//营业额
	@Column(name = "cus_bank")
	private String cusBank;		//开户银行
	@Column(name = "cus_bankaccount")
	private String cusBankAccount;	//银行帐号
	@Column(name = "cus_landtax")
	private String cusLandTax;		//地税登记号
	@Column(name = "cus_tax")
	private String cusTax;		//国税登记号
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusNum() {
		return cusNum;
	}

	public void setCusNum(String cusNum) {
		this.cusNum = cusNum;
	}

	public String getCusAddr() {
		return cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	public Integer getCusLevel() {
		return cusLevel;
	}

	public void setCusLevel(Integer cusLevel) {
		this.cusLevel = cusLevel;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Integer getCusSatisfaction() {
		return cusSatisfaction;
	}

	public void setCusSatisfaction(Integer cusSatisfaction) {
		this.cusSatisfaction = cusSatisfaction;
	}

	public Integer getCusCredibility() {
		return cusCredibility;
	}

	public void setCusCredibility(Integer cusCredibility) {
		this.cusCredibility = cusCredibility;
	}

	public String getCusArea() {
		return cusArea;
	}

	public void setCusArea(String cusArea) {
		this.cusArea = cusArea;
	}

	public String getCusTel() {
		return cusTel;
	}

	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}

	public Integer getCusZipCode() {
		return cusZipCode;
	}

	public void setCusZipCode(Integer cusZipCode) {
		this.cusZipCode = cusZipCode;
	}

	public String getCusFax() {
		return cusFax;
	}

	public void setCusFax(String cusFax) {
		this.cusFax = cusFax;
	}

	public String getCusUrl() {
		return cusUrl;
	}

	public void setCusUrl(String cusUrl) {
		this.cusUrl = cusUrl;
	}

	public String getCusBusLicNum() {
		return cusBusLicNum;
	}

	public void setCusBusLicNum(String cusBusLicNum) {
		this.cusBusLicNum = cusBusLicNum;
	}

	public String getCusLegalPerson() {
		return cusLegalPerson;
	}

	public void setCusLegalPerson(String cusLegalPerson) {
		this.cusLegalPerson = cusLegalPerson;
	}

	public Double getCusRegisCapital() {
		return cusRegisCapital;
	}

	public void setCusRegisCapital(Double cusRegisCapital) {
		this.cusRegisCapital = cusRegisCapital;
	}

	public Double getCusTurnover() {
		return cusTurnover;
	}

	public void setCusTurnover(Double cusTurnover) {
		this.cusTurnover = cusTurnover;
	}

	public String getCusBank() {
		return cusBank;
	}

	public void setCusBank(String cusBank) {
		this.cusBank = cusBank;
	}

	public String getCusBankAccount() {
		return cusBankAccount;
	}

	public void setCusBankAccount(String cusBankAccount) {
		this.cusBankAccount = cusBankAccount;
	}

	public String getCusLandTax() {
		return cusLandTax;
	}

	public void setCusLandTax(String cusLandTax) {
		this.cusLandTax = cusLandTax;
	}

	public String getCusTax() {
		return cusTax;
	}

	public void setCusTax(String cusTax) {
		this.cusTax = cusTax;
	}
}
