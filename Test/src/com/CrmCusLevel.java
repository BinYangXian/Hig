package com;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the crm_cus_level database table.
 * 
 */
@Entity
@Table(name="crm_cus_level")
@NamedQuery(name="CrmCusLevel.findAll", query="SELECT c FROM CrmCusLevel c")
public class CrmCusLevel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="level_id")
	private int levelId;

	@Column(name="level_name")
	private String levelName;

	@Column(name="level_num")
	private String levelNum;

	private String remark1;

	private String remark2;

	private String remark3;

	//bi-directional many-to-one association to CrmCustomer
	private Set<CrmCustomer> crmCustomers;

	public CrmCusLevel() {
	}

	public int getLevelId() {
		return this.levelId;
	}

	public void setLevelId(int levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return this.levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelNum() {
		return this.levelNum;
	}

	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
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

	public Set<CrmCustomer> getCrmCustomers() {
		return this.crmCustomers;
	}

	public void setCrmCustomers(Set<CrmCustomer> crmCustomers) {
		this.crmCustomers = crmCustomers;
	}

	public CrmCustomer addCrmCustomer(CrmCustomer crmCustomer) {
		getCrmCustomers().add(crmCustomer);
		crmCustomer.setCrmCusLevel(this);

		return crmCustomer;
	}

	public CrmCustomer removeCrmCustomer(CrmCustomer crmCustomer) {
		getCrmCustomers().remove(crmCustomer);
		crmCustomer.setCrmCusLevel(null);

		return crmCustomer;
	}

}