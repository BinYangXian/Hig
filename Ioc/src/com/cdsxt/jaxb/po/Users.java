package com.cdsxt.jaxb.po;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="User")
public class Users {
	
	/**
	 * <User id="1">
	 * 	<username>lisi</username>
	 * 	<password>123123</password>
	 * 	<email>lisi@lisi.com</email>
	 * </User>
	 * 
	 * 
	 * 
	 */
	private Integer id;
	private String username;
	private String password;
	private String email;
	
	@XmlAttribute(name="id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@XmlElement(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
