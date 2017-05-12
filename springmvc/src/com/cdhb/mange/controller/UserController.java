package com.cdhb.mange.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cdhb.mange.po.User;
import com.cdhb.mange.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserService service;
	@RequestMapping("/add.do")
	public  ModelAndView add(User user1 ,HttpServletRequest request){
		/*System.out.println(request.getParameter("name")+"++++++"+request.getParameter("age"));*/
		/*System.out.println(user.getName()+"+++++++"+user.getAge());*/
		System.out.println(user1.getName());
		System.out.println(user1.getAge());
		service.add();
		User use3=new User();
		use3.setAge(15);
		use3.setName("wu");
		request.setAttribute("use3", use3);
		
	/*	User user=new User();
		user.setName("zhangsan");
		user.setAge(18);*/
		System.out.println(66666);
		/*ModelAndView view =new ModelAndView("/index");
		view.addObject("user", user);
		return view;*/
		/*return new ModelAndView("/index", "user", user);*/
		return new ModelAndView("/index");
		
	}
	@RequestMapping("/ajax.do")
	@ResponseBody
	public String ajax(){
		
		return "66666666666" ;
		
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
	
}
