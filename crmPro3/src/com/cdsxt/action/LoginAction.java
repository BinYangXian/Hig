package com.cdsxt.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;

import com.cdsxt.po.Menu;
import com.cdsxt.po.Role;
import com.cdsxt.po.Users;
import com.cdsxt.service.MenuService;
import com.cdsxt.service.RoleService;
import com.cdsxt.service.UsersService;
import com.cdsxt.vo.MenuVo;
import com.cdsxt.vo.RoleVo;
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
	private RoleService roleService;
	
	private List<MenuVo> vos;
	
	private String username;
	private String password;
	//验证码
	private String valicode;
	
	private Integer roleId;
	
	private List<RoleVo> rvos;
	
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
				if(this.roleId!=null){
					Users users = this.usersService.findByUsername(username);
					if(users!=null && users.getPassword()!=null && users.getPassword().equals(password)){
						//判断角色
						Role role = this.roleService.findById(roleId);
						//得到登录用户的角色结果集
						Set<Role> roles = users.getRoles();
						if(roles==null || roles.isEmpty()){
							this.msg = "角色错误!";
							return "login";
						}
						
						if(!roles.contains(role)){
							this.msg = "角色错误!";
							return "login";
						}
						
						//登录成功
						//将登录成功的用户  存入session中
						session.put("logined", users);
						//得到当前登录角色所拥有的菜单 
						//将他放入session中
						Set<Menu> menus = role.getMenus();
						//构造MenuVo  将其放入Session
						List<MenuVo> vos = new ArrayList<>();
						for(Menu menu:menus){
							MenuVo vo = new MenuVo(menu);
							vos.add(vo);
						}
						session.put("menus", vos);
						
						return "main";
					}
				}else{
					this.msg = "请选择角色!";
					return "login";
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
	@SuppressWarnings("unchecked")
	public String findMenuToLeft(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		this.vos = (List<MenuVo>) session.get("menus");
		if(this.vos == null){
			this.vos = new ArrayList<>();
		}
		return "left";
	}
	
	public String findAllRole(){
		this.rvos = new ArrayList<>();
		List<Role> roles = this.roleService.findAll();
		if(!CollectionUtils.isEmpty(roles)){
			for(Role role:roles){
				RoleVo vo = new RoleVo(role);
				this.rvos.add(vo);
			}
		}
		return "findAllRole";
		
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<RoleVo> getRvos() {
		return rvos;
	}

	public void setRvos(List<RoleVo> rvos) {
		this.rvos = rvos;
	}
}
