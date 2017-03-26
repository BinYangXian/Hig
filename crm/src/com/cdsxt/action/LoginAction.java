package com.cdsxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.cdsxt.po.Menu;
import com.cdsxt.po.Role;
import com.cdsxt.po.RoleModule;
import com.cdsxt.po.Users;
import com.cdsxt.service.RoleService;
import com.cdsxt.service.UsersService;
import com.cdsxt.vo.MenuVo;
import com.cdsxt.vo.RoleVo;
import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class LoginAction {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RoleService roleService;
	
	private List<RoleVo> roleVos;
	
	private List<MenuVo> menuVos;
	
	private String username;
	private String password;
	
	private Integer roleId;
	//验证码
	private String valicode;
	
	private String error = "";

	//登陆方法
	public String login(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		Object code = session.get("rand");
		if(StringUtils.hasLength(valicode) && valicode.toLowerCase().equals(code.toString().toLowerCase())){
			if(this.roleId!=null){
				if(StringUtils.hasLength(this.username)){
					Users users = this.usersService.findByUsername(this.username);
					if(users!=null){
						if(StringUtils.hasLength(password) && password.equals(users.getPassword())){
							if(exist(users.getRoles())){
								
								//成功的代码
								session.put("admin",users);
								return "main";
							}
						}
					}
				}
				this.error = "用户名或密码错误,请重试!";
				return "login";
			}
			this.error = "请选择角色!";
			return "login";
		}
		this.error = "验证码错误,请重试!";
		return "login";
	}
	
	private boolean exist(Set<Role> roles){
		boolean exists = false;
		if(roles!=null && !roles.isEmpty()){
			for(Role role:roles){
				if(role.getId()==this.roleId){
					exists = true;
					
					Set<Menu> menus = role.getMenus();
					if(menus!=null){
						menus.size();
					}
					
					Map<String,Object> session = ActionContext.getContext().getSession();
					session.put("menus", menus);
					
					
					//得到当前角色所拥有的 模块  然后 构造Map<String,Integer>  key 为module的url  Integer 为该module所对应的权限
					//到该角色已经拥有的 模块
					Map<String,Integer> powers = new HashMap<String, Integer>();
					Set<RoleModule> rms = role.getRoleModule();
					
					if(rms!=null){
						for(RoleModule rm:rms){
							String url = rm.getModule().getUrl();
							powers.put(url, rm.getPowerCode());
						}
					}
					session.put("powers", powers);
					
					break;
				}
			}
		}
		return exists;
	}
	
	@SuppressWarnings("unchecked")
	public String findAllToLeft(){
		this.menuVos = new ArrayList<MenuVo>();
		Map<String,Object> session = ActionContext.getContext().getSession();
		Set<Menu> menus = (Set<Menu>) session.get("menus");
		if(menus!=null){
			for(Menu menu:menus){
				Menu parent = menu.getParent();
				MenuVo vo = new MenuVo();
				vo.setMenuId(menu.getMenuId());
				vo.setParentId(parent==null?0:parent.getMenuId());
				vo.setMenuName(menu.getMenuName());
				vo.setMenuUrl(menu.getMenuUrl());
				this.menuVos.add(vo);
			}
		}
		
		return "findAllToLeft";
		
	}
	
	//安全退出
	public String logout(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "logout";
	}
	
	public String findAllRoles(){
		this.roleVos = this.roleService.findAllToVo();
		return "findAllRoles";
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

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getValicode() {
		return valicode;
	}

	public void setValicode(String valicode) {
		this.valicode = valicode;
	}

	public List<RoleVo> getRoleVos() {
		return roleVos;
	}

	public void setRoleVos(List<RoleVo> roleVos) {
		this.roleVos = roleVos;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public List<MenuVo> getMenuVos() {
		return menuVos;
	}

	public void setMenuVos(List<MenuVo> menuVos) {
		this.menuVos = menuVos;
	}
}
