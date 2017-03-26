package com.cdsxt.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.cdsxt.po.Users;

public class ParamAction {
	
	//默认或方法request中 [get方法]
	//如果要想得到前台转入的值  就一定要写set方法
	private String username;
	private Integer id;
	private String password;
	private Long sal;
	private Boolean bool;
	
	private Integer[] ids;
	
	private List<String> list;
	private Map<String,String> map;//页面到服务器传参时注意，map["xxx"]=... (或者map.xxx)其中的引号，取值方式的语法同json/类选择器。
	
	private Users users;
	
	//不针对 form method[get post]
	public void execute(){
		System.out.println(this);
		System.out.println(Arrays.toString(ids));
		System.out.println(this.list);
		System.out.println(this.map);
		System.out.println(this.users);
	}
	
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getUsername(){
		return this.username;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Long getSal() {
		return sal;
	}


	public void setSal(Long sal) {
		this.sal = sal;
	}


	public Boolean getBool() {
		return bool;
	}


	public void setBool(Boolean bool) {
		this.bool = bool;
	}


	@Override
	public String toString() {
		return "ParamAction [username=" + username + ", id=" + id + ", password=" + password + ", sal=" + sal
				+ ", bool=" + bool + "]";
	}


	public Integer[] getIds() {
		return ids;
	}


	public void setIds(Integer[] ids) {
		this.ids = ids;
	}


	public List<String> getList() {
		return list;
	}


	public void setList(List<String> list) {
		this.list = list;
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}


	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	

}
