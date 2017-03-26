package com.cdsxt.po;

import java.io.Serializable;

public class PersonName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8616621541119796174L;
	private String firstName;
	private String lastName;
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
