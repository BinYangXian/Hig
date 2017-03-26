package com.cdsxt.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.cdsxt.web.po.Menu;
import com.cdsxt.web.po.Role;
import com.cdsxt.web.po.User;
import com.cdsxt.web.service.RoleService;
import com.cdsxt.web.service.UserService;
import com.cdsxt.web.util.MD5keyBean;
import com.cdsxt.web.vo.MenuVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;
	private String userName;
	private String password;
	private User loginUser;
	private Role loginRole;
	
	private List<MenuVo> userMenuVo;
	
	
	
	
	public void validateLogin(){
		//取消登陆验证
		userName="admin";
		password="admin";
		password=new MD5keyBean().getkeyBeanofStr(password);		
		if(!StringUtils.hasLength(userName)||!StringUtils.hasLength(password)){
			this.addFieldError("msg", "用户名或密码不能为空");
		}else {
			loginUser=userService.findByUserName(userName);
			if(loginUser==null){
				this.addFieldError("msg", "用户不存在");
			}else if (loginUser.getRoles().isEmpty()) {
				this.addFieldError("msg", "获取用户角色失败，请联系系统管理员");
			}
		}
		//password转化MD5
		
	}
	public String login(){
		if(password.equals(loginUser.getPassword())){
			Map<String, Object> session=ActionContext.getContext().getSession();
			session.put("loginUser", loginUser);
			loginRole=loginUser.getRoles().get(0);
			session.put("loginRole", loginRole);
			Map<String, Integer> roleMap=new HashMap<String, Integer>();
			roleMap=roleService.RolePowercodeUrl(loginRole);
			session.put("roleMap", roleMap);
			return SUCCESS;
		}else {
			this.addFieldError("msg", "用户密码错误");
			return INPUT;
		}
	}
	
	//渲染左侧菜单
	public String findUserMenu(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		loginRole=(Role) session.get("loginRole");
		Set<Menu> menus=loginRole.getMenus();
		userMenuVo=new ArrayList<MenuVo>();
		for(Menu menu:menus){
			userMenuVo.add(new MenuVo(menu));
		}
		return "findUserMenu";
	}
	
	//退出系统
	public String exit(){
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.clear();
		return "exit";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<MenuVo> getUserMenuVo() {
		return userMenuVo;
	}
	public void setUserMenuVo(List<MenuVo> userMenuVo) {
		this.userMenuVo = userMenuVo;
	}

}
