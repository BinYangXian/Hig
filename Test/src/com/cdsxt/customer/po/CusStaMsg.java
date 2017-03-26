package com.cdsxt.customer.po;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cus_sta_msg database table.
 * 
 */
@Entity
@Table(name="cus_sta_msg")
@NamedQuery(name="CusStaMsg.findAll", query="SELECT c FROM CusStaMsg c")
public class CusStaMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Temporal(TemporalType.DATE)
	@Column(name="dan_sta_date")
	private Date danStaDate;

	private String remark1;

	private String remark2;

	@Column(name="sta_msg")
	private String staMsg;

	@Column(name="sta_type")
	private String staType;

	//bi-directional many-to-one association to CrmCustomer
	@ManyToOne
	@JoinColumn(name="cus_id")
	private CrmCustomer crmCustomer;

	public CusStaMsg() {
	}

	public Date getDanStaDate() {
		return this.danStaDate;
	}

	public void setDanStaDate(Date danStaDate) {
		this.danStaDate = danStaDate;
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

	public String getStaMsg() {
		return this.staMsg;
	}

	public void setStaMsg(String staMsg) {
		this.staMsg = staMsg;
	}

	public String getStaType() {
		return this.staType;
	}

	public void setStaType(String staType) {
		this.staType = staType;
	}

	public CrmCustomer getCrmCustomer() {
		return this.crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}

}