package com.cdsxt.action;

import java.util.List;
import java.util.Map;

import com.cdsxt.po.Users;

public class Index {
	private Map<String,Integer> map;
	private List<String> list;
	private Users users;
	public void execute(){
		System.out.println("Index.execute()");
		System.out.println(map);
		System.out.println(list);
		System.out.println(users);
	}
	public Map<String, Integer> getMap() {
		return map;
	}
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
