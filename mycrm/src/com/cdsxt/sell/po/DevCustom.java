package com.cdsxt.sell.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//待开发客户
@Entity
@Table(name="crm_devcustom")
public class DevCustom {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dev_id")
	private Integer id;
	private String name; //客户名称
	private String describe; //概要，机会描述
	private String phone; //客户手机
	private String source;  //来源
	@Column(name="state_code")
	private Integer stateCode; //0：未开发，1，已开发，-1 开发失败
	@OneToOne(mappedBy="devCustom")
	private SalesOpp salesOpp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public SalesOpp getSalesOpp() {
		return salesOpp;
	}

	public void setSalesOpp(SalesOpp salesOpp) {
		this.salesOpp = salesOpp;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}
	
	
}
