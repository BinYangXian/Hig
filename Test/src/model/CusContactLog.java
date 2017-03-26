package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cus_contact_log database table.
 * 
 */
@Entity
@Table(name="cus_contact_log")
@NamedQuery(name="CusContactLog.findAll", query="SELECT c FROM CusContactLog c")
public class CusContactLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user;

	@Column(name="con_addr")
	private String conAddr;

	@Column(name="con_bref")
	private String conBref;

	@Temporal(TemporalType.DATE)
	@Column(name="con_date")
	private Date conDate;

	@Column(name="con_detail")
	private String conDetail;

	@Column(name="con_mark")
	private String conMark;

	private String remark1;

	private String remark2;

	private String remark3;

	//bi-directional many-to-one association to CrmCustomer
	@ManyToOne
	@JoinColumn(name="cus_id")
	private CrmCustomer crmCustomer;

	public CusContactLog() {
	}

	public int getUser() {
		return this.user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getConAddr() {
		return this.conAddr;
	}

	public void setConAddr(String conAddr) {
		this.conAddr = conAddr;
	}

	public String getConBref() {
		return this.conBref;
	}

	public void setConBref(String conBref) {
		this.conBref = conBref;
	}

	public Date getConDate() {
		return this.conDate;
	}

	public void setConDate(Date conDate) {
		this.conDate = conDate;
	}

	public String getConDetail() {
		return this.conDetail;
	}

	public void setConDetail(String conDetail) {
		this.conDetail = conDetail;
	}

	public String getConMark() {
		return this.conMark;
	}

	public void setConMark(String conMark) {
		this.conMark = conMark;
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

	public CrmCustomer getCrmCustomer() {
		return this.crmCustomer;
	}

	public void setCrmCustomer(CrmCustomer crmCustomer) {
		this.crmCustomer = crmCustomer;
	}

}