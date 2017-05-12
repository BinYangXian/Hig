package com.cdhb.dao;

public class User {
  Integer age;
  String  name;
public User(Integer age, String name) {
	super();
	this.age = age;
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
  
}
