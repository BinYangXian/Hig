package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cdsxt.dao.BaseDao;
import com.cdsxt.dao.impl.UsersDaoImpl;
import com.cdsxt.po.Users;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

public class MyUsersAction {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer age;
	public String execute(){
		Map<String,Object> request=((Map<String,Object>)ActionContext.getContext().get("request"));
		request.put("users", new UsersDaoImpl().findAll());
		return "simpleDispatcher";
	}
	public String addUser(){
		String sql = "insert into users values(?,?,?,?,?)";
		BaseDao.change(sql, new Object[] {id,username,password,email,age });
		Map<String,Object> request=((Map<String,Object>)ActionContext.getContext().get("request"));
		request.put("users", new UsersDaoImpl().findAll());
		return "simpleDispatcher";
	}
	public String delete() {
		String sql = "delete from users where id=?";
		BaseDao.change(sql, new Object[] { id });
		Map<String,Object> request=((Map<String,Object>)ActionContext.getContext().get("request"));
		request.put("users", new UsersDaoImpl().findAll());
		return "simpleDispatcher";
	}
	public String update() {
		String sql = "update users set username=?,password=?,email=?,age=? where id=?";
		BaseDao.change(sql, new Object[] { username,password,email,age,id });
		Map<String,Object> request=((Map<String,Object>)ActionContext.getContext().get("request"));
		request.put("users", new UsersDaoImpl().findAll());
		return "simpleDispatcher";
	}
	public void findOne()  {
		String json = "{\"code\":101,\"message\":\"没有找到对应的数据!\"}";
			Users users = new UsersDaoImpl().findOne(id);
			if(users!=null){
				json = new Gson().toJson(users);
			}
		PrintWriter writer;
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		
		try {
			writer = response.getWriter();
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
