package com.cdsxt;

import com.cdsxt.annotation.Column;
import com.cdsxt.annotation.Id;
import com.cdsxt.annotation.Table;

/**
 * 
 * create table 表名(
 *   列  数据类型  是否为主键
 *   ....
 * )
 * 
 * 
 * @author Administrator
 *
 */

@Table(name="test_person")
public class Person {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
