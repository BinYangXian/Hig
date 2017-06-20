package com.cdsxt.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "crm_cus_level")
public class CustomerLevel {
	// 客户等级
	@Id
	@SequenceGenerator(name = "seqLevel", sequenceName = "seq_crm_cus_level")
	@GeneratedValue(generator = "seqLevel")
	@Column(name = "level_id")
	private Integer levelId;
	@Column(name = "level_name")
	private String levelName;
	@Column(name = "level_num")
	private String levelNum;
	@Column(name = "level_remark1")
	private String remark1;
	@Column(name = "level_remark2")
	private String remark2;
	@Column(name = "level_remark3")
	private String remark3;

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getLevelNum() {
		return levelNum;
	}

	public void setLevelNum(String levelNum) {
		this.levelNum = levelNum;
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
