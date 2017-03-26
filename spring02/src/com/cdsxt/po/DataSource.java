package com.cdsxt.po;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)  //lazy-init
@Scope("prototype")
public class DataSource {
	
	@Value("${jdbc_driver}")
	private String driver;
	//@Value 表示注入值  这里里面可以使用#  也可以使用$  ${user:aaa}
	//其中 user没有值的时候  aaa则是默认值
	@Value("${user:aaaa}")
	private String user;
	@Value("#{@ua.getPassword()}")
	private String pwd;
	private String url;
	
	@PostConstruct   //init-method
	public void init(){
		System.out.println("DataSource.init()");
	}
	@PreDestroy  //destroy-method
	public void destroy(){
		System.out.println("DataSource.destroy()");
	}
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
//	@Override
//	public String toString() {
//		return "DataSource [driver=" + driver + ", user=" + user + ", pwd=" + pwd + ", url=" + url + "]";
//	}
	

}
