package com.cdsxt.po;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 8239741381850161374L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
	}

}
