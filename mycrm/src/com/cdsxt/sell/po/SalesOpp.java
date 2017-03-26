package com.cdsxt.sell.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cdsxt.web.po.Staff;
import com.cdsxt.web.po.User;

@Entity
@Table(name="crm_sales_opp")
public class SalesOpp {
	@Id
	private Integer id;

	@Column(name="success_rate")
	private Integer successRate; //成功几率
	
	@Column(name="add_date")
	private Date addDate; //创建时间
	@ManyToOne
	@JoinColumn(name="add_user_id")
	private User addUser; //创建用户
	@ManyToOne
	@JoinColumn(name="desig_staff_id")
	private Staff desigStaff; //指定员工--限定客户经理
	@Column(name="desig_date")
	private Date desigDate; //由系统自动创建--指定员工后生成
	@OneToOne
	@JoinColumn(name="dev_custom_id")
	private DevCustom devCustom;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(Integer successRate) {
		this.successRate = successRate;
	}

	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public User getAddUser() {
		return addUser;
	}
	public void setAddUser(User addUser) {
		this.addUser = addUser;
	}
	public Staff getDesigStaff() {
		return desigStaff;
	}
	public void setDesigStaff(Staff desigStaff) {
		this.desigStaff = desigStaff;
	}
	public Date getDesigDate() {
		return desigDate;
	}
	public void setDesigDate(Date desigDate) {
		this.desigDate = desigDate;
	}
	public DevCustom getDevCustom() {
		return devCustom;
	}
	public void setDevCustom(DevCustom devCustom) {
		this.devCustom = devCustom;
	}
	
	
}
