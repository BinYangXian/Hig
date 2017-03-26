package com.cdsxt.web.vo;

import java.util.Date;

import com.cdsxt.web.po.Staff;

public class StaffVo {
	
	private Integer id;
	private String name;
	private String gender;
	private Date entryDate;
	private String phone;
	private String email;
	private String addr;
	private String roleName;
	private String userName;
	private Integer userId;
	public StaffVo(Staff staff) {
		this.id=staff.getId();
		this.name=(staff.getName()==null?"":staff.getName());
		this.gender=(staff.getGender()==null?"":staff.getGender());
		this.entryDate=(staff.getEntryDate()==null?new Date():staff.getEntryDate());
		this.phone=(staff.getPhone()==null?"":staff.getPhone());
		this.email=(staff.getEmail()==null?"":staff.getEmail());
		this.addr=(staff.getAddr()==null?"":staff.getAddr());	
	}
	public StaffVo(Staff staff,String roleName) {
		this.id=staff.getId();
		this.name=(staff.getName()==null?"":staff.getName());
		this.gender=(staff.getGender()==null?"":staff.getGender());
		this.entryDate=(staff.getEntryDate()==null?new Date():staff.getEntryDate());
		this.phone=(staff.getPhone()==null?"":staff.getPhone());
		this.email=(staff.getEmail()==null?"":staff.getEmail());
		this.addr=(staff.getAddr()==null?"":staff.getAddr());
		this.roleName=roleName;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public StaffVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
