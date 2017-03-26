package com.cdsxt.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="test_husband")
public class Husband {
	
	@Id
	@SequenceGenerator(name="seqHusband",sequenceName="seq_test_husband")
	@GeneratedValue(generator="seqHusband")
	private Integer id;
	private String hname;
	
	@OneToOne
	@PrimaryKeyJoinColumn  //表示主键加入方
	private Wife wife;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public Wife getWife() {
		return wife;
	}
	public void setWife(Wife wife) {
		this.wife = wife;
	}
}
