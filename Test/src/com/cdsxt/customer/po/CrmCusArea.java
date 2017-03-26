package com.cdsxt.customer.po;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the crm_cus_area database table.
 * 
 */
@Entity
@Table(name="crm_cus_area")
@NamedQuery(name="CrmCusArea.findAll", query="SELECT c FROM CrmCusArea c")
public class CrmCusArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="area_id")
	private int areaId;

	@Column(name="area_name")
	private String areaName;

	@Column(name="area_num")
	private String areaNum;

	@Column(name="area_remark1")
	private String areaRemark1;

	@Column(name="area_remark2")
	private String areaRemark2;

	@Column(name="area_remark3")
	private String areaRemark3;

	//bi-directional many-to-one association to CrmCustomer
	@OneToMany(mappedBy="crmCusArea")
	private Set<CrmCustomer> crmCustomers;

	public CrmCusArea() {
	}

	public int getAreaId() {
		return this.areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return this.areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaNum() {
		return this.areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}

	public String getAreaRemark1() {
		return this.areaRemark1;
	}

	public void setAreaRemark1(String areaRemark1) {
		this.areaRemark1 = areaRemark1;
	}

	public String getAreaRemark2() {
		return this.areaRemark2;
	}

	public void setAreaRemark2(String areaRemark2) {
		this.areaRemark2 = areaRemark2;
	}

	public String getAreaRemark3() {
		return this.areaRemark3;
	}

	public void setAreaRemark3(String areaRemark3) {
		this.areaRemark3 = areaRemark3;
	}

	public Set<CrmCustomer> getCrmCustomers() {
		return this.crmCustomers;
	}

	public void setCrmCustomers(Set<CrmCustomer> crmCustomers) {
		this.crmCustomers = crmCustomers;
	}

	public CrmCustomer addCrmCustomer(CrmCustomer crmCustomer) {
		getCrmCustomers().add(crmCustomer);
		crmCustomer.setCrmCusArea(this);

		return crmCustomer;
	}

	public CrmCustomer removeCrmCustomer(CrmCustomer crmCustomer) {
		getCrmCustomers().remove(crmCustomer);
		crmCustomer.setCrmCusArea(null);

		return crmCustomer;
	}

}