package com.cdsxt.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "crm_cus_area")
public class Area {
	//地区
	@Id
	@SequenceGenerator(name="seqArea",sequenceName="seq_crm_cus_area")
	@GeneratedValue(generator="seqArea")
	@Column(name="area_id")
	private Integer areaId;
	@Column(name="area_name")
	private String areaName;
	@Column(name="area_num")
	private String areaNum;
	@Column(name="area_remark1")
	private String remark1;
	@Column(name="area_remark2")
	private String remark2;
	@Column(name="area_remark3")
	private String remark3;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaNum() {
		return areaNum;
	}

	public void setAreaNum(String areaNum) {
		this.areaNum = areaNum;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

}
