package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cus_linkman database table.
 * 
 */
@Entity
@Table(name="cus_linkman")
@NamedQuery(name="CusLinkman.findAll", query="SELECT c FROM CusLinkman c")
public class CusLinkman implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cus_linkman_id")
	private int cusLinkmanId;

	@Column(name="linkman_mark")
	private String linkmanMark;

	@Column(name="linkman_mgr")
	private String linkmanMgr;

	@Column(name="linkman_name")
	private String linkmanName;

	@Column(name="linkman_phone")
	private String linkmanPhone;

	@Column(name="linkman_sex")
	private int linkmanSex;

	@Column(name="linkman_tel")
	private String linkmanTel;

	private String remark1;

	private String remark2;

	private String remark3;

	//bi-directional many-to-one association to CrmCustomer
	@ManyToOne
	@JoinColumn(name="cus_id")
	private CrmCustomer crmCustomer;

	public CusLinkman() {
	}

	public int getCusLinkmanId() {
		return this.cusLinkmanId;
	}

	public void setCusLinkmanId(int cusLinkmanId) {
		this.cusLinkmanId = cusLinkmanId;
	}

	public String getLinkmanMark() {
		return this.linkmanMark;
	}

	public void setLinkmanMark(String linkmanMark) {
		this.linkmanMark = linkmanMark;
	}

	public String getLinkmanMgr() {
		return this.linkmanMgr;
	}

	public void setLinkmanMgr(String linkmanMgr) {
		this.linkmanMgr = linkmanMgr;
	}

	public String getLinkmanName() {
		return this.linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanPhone() {
		return this.linkmanPhone;
	}

	public void setLinkmanPhone(String linkmanPhone) {
		this.linkmanPhone = linkmanPhone;
	}

	public int getLinkmanSex() {
		return this.linkmanSex;
	}

	public void setLinkmanSex(int linkmanSex) {
		this.linkmanSex = linkmanSex;
	}

	public String getLinkmanTel() {
		return this.linkmanTel;
	}

	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
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