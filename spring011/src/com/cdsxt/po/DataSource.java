package com.cdsxt.po;

public class DataSource {
	
	private String driver;
	private String user;
	private String pwd;
	private String url;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "DataSource [driver=" + driver + ", user=" + user + ", pwd=" + pwd + ", url=" + url + "]";
	}
	

}
