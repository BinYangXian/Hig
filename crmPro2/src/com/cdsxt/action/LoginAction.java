package com.cdsxt.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Users;
import com.cdsxt.service.MenuService;
import com.cdsxt.service.UsersService;
import com.cdsxt.vo.MenuVo;
import com.opensymphony.xwork2.ActionContext;

/**
 * @author Administrator
 *
 */
@Controller
@Scope("prototype")
public class LoginAction {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private MenuService menuService;
	private List<MenuVo> vos;
	
	private String username;
	private String password;
	//验证码
	private String valicode;
	
	private String msg;
	
	public String login(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		//得到验证码
		Object rand = session.get("rand");
		if(rand==null){
			this.msg = "验证码错误,请重试!";
			return "login";
		}
		
		if(rand.toString().equalsIgnoreCase(valicode)){
			if(username!=null){
				Users users = this.usersService.findByUsername(username);
				if(users!=null && users.getPassword()!=null && users.getPassword().equals(password)){
					//登录成功
					//将登录成功的用户  存入session中
					session.put("logined", users);
					return "main";
				}
			}
			this.msg = "用户名或密码错误,请重试!";
		}else{
			this.msg = "验证码错误,请重试!";
		}
		return "login";
	}
	
	public String logout(){
		//强制失效
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	
	//用于显示左侧菜单
	public String findMenuToLeft(){
		this.vos = this.menuService.findAllToVo();
		return "left";
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<MenuVo> getVos() {
		return vos;
	}

	public void setVos(List<MenuVo> vos) {
		this.vos = vos;
	}

	public String getValicode() {
		return valicode;
	}

	public void setValicode(String valicode) {
		this.valicode = valicode;
	}
}
