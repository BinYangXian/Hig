package com.cdsxt.action;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.cdsxt.po.Users;

public class Beans {
	
	private String name;
	private Integer age;
	private Double sal;
	
	private Users users;
	
	private List<String> list;
	private Set<String> set;
	
	private Map<String,String> map;
	
	private Properties prop;
	
	public Beans(){
		System.out.println("Beans.Beans()");
	}
	
	public void init(){
		System.out.println("Beans.init()");
		System.out.println(this);
		System.out.println(this.users);
		System.out.println(this.list);
		System.out.println(this.set);
		System.out.println(this.map);
		System.out.println(this.prop);
	}
	
	public void destroy(){
		System.out.println("Beans.destroy()");
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

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Beans [name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
	

}
