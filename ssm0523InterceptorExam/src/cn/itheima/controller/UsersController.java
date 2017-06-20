package cn.itheima.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itheima.pojo.User;
import cn.itheima.service.UserService;

@RequestMapping("/login")
@Controller
public class UsersController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public String login() throws Exception{
		return "login";
	}
	@RequestMapping("/submit")
	public String submit(User user,Model model,HttpServletRequest request){
		System.out.println("do submit!!!!!!!!!!!!");
		String result=null;
		User resultUser = userService.selectUser(user);
		if(resultUser==null){
			model.addAttribute("systemMsg", "用户名或密码错误！");
			result="forward:login.action";
		}else{
			result="redirect:../list.action"; 
			HttpSession session = request.getSession(); 
			session.setAttribute("uid", resultUser.getUid());
		}
		return result;
	}
}
