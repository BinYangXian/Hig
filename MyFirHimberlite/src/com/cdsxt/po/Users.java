package com.cdsxt.po;

import java.io.Serializable;

public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6370860388719638248L;
	private String id;
	private String name;
	private Integer age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

}
