package com.cdsxt.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.cdsxt.web.po.Role;
import com.cdsxt.web.po.User;
import com.cdsxt.web.service.RoleService;
import com.cdsxt.web.service.UserService;
import com.cdsxt.web.util.MD5keyBean;
import com.cdsxt.web.util.PageUtil;
import com.cdsxt.web.vo.RoleVo;
import com.cdsxt.web.vo.UserVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UserAction  extends ActionSupport{
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	private String newPwd;
	
	private String oldPwd;
	
	private User loginUser;
	
	private Integer userId;
	
	private List<RoleVo> roleVos;
	
	private Integer roleId;
	
	private String username;
	
	private String password;
	
	private Integer curPage;
	
	private List<UserVo> userVos;
	
	private PageUtil page;
	
	public String findAll(){
		if(curPage==null){
			curPage=1;
		}
		int rowCount=this.userService.findCount();
		page=new PageUtil(curPage, rowCount);
		userVos=new ArrayList<UserVo>();
		List<User> users=userService.findForPage(page.getStartRow(), page.getPageRow());
		for (User user : users) {
			UserVo userVo=new UserVo();
			userVo.setUserId(user.getId());
			userVo.setUserName(user.getUserName());
			userVo.setStaffName(user.getStaff()==null?"":user.getStaff().getName());
			userVo.setRoleName(user.getRoles().isEmpty()?"":user.getRoles().get(0).getRoleName());
			userVos.add(userVo);
		}
		return "findAll";
	}

	public void validateUpdatePwd(){
		if(StringUtils.hasLength(newPwd)&&StringUtils.hasLength(oldPwd)){
			MD5keyBean md5=new MD5keyBean();
			newPwd=md5.getkeyBeanofStr(newPwd);
			oldPwd=md5.getkeyBeanofStr(oldPwd);
			if(newPwd.equals(oldPwd)){
				this.addFieldError("msg", "密码相同，请重新输入");
			}else {
				Map<String,Object> session=ActionContext.getContext().getSession();
				loginUser=(User) session.get("loginUser");
				if(!oldPwd.equals(loginUser.getPassword())){
					this.addFieldError("msg", "密码输入不正确");
				}
			}
		}else{
			this.addFieldError("msg","密码不能为空");
		}
	}
	//修改登录用户密码
	public String updatePwd(){
		userService.updatePwd(loginUser, newPwd);
		Map<String, Object> session=ActionContext.getContext().getSession();
		session.clear();
		this.addFieldError("msg", "修改成功，请重新登陆");
		return "updatePwd";
	}
	
	//找到所有角色，用于添加账户选择角色
	public String getRoleVo(){
		roleVos=roleService.findAllRoleVo();
		return "getRoleVo";
	}
	
	public void validateAddUser(){
		if(userService.findByUserName(username)!=null){
			this.addFieldError("msg", username+"此用户名已存在");
		}	
		password=new MD5keyBean().getkeyBeanofStr(password);
	}
	//添加账户
	public String addUser(){
		List<Role> roleList=new ArrayList<Role>();
		Role role=roleService.findById(roleId);
		roleList.add(role);
		User newUser=new User();
		newUser.setUserName(username);
		newUser.setPassword(password);
		newUser.setRoles(roleList);
		userService.addRole(newUser);
		return "addUser";
	}
	private User updateUser;
	public void validateUpdateUser(){
		updateUser=userService.findById(userId);
		System.out.println(updateUser.getUserName()+"名字是");
		System.out.println(username);
		if(userService.findByUserName(username)!=null&&!updateUser.getUserName().equals(username)){
			this.addFieldError("msg", username+"此用户名已存在");
		}	
		password=new MD5keyBean().getkeyBeanofStr(password);
	}
	
	//管理员修改账户
	public String updateUser(){
		List<Role> roleList=new ArrayList<Role>();
		roleList.add(roleService.findById(roleId));
		updateUser.setRoles(roleList);
		updateUser.setPassword(password);
		updateUser.setUserName(username);
		userService.updateUser(updateUser);
		return "updateUser";
	}
	
	//删除账号
	public String deleteUser(){
		User user=this.userService.findById(userId);
		this.userService.deleteUser(user);
		return "deleteUser";
	}
	
	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
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

	public PageUtil getPage() {
		return page;
	}

	public void setPage(PageUtil page) {
		this.page = page;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public List<UserVo> getUserVos() {
		return userVos;
	}

	public void setUserVos(List<UserVo> userVos) {
		this.userVos = userVos;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
