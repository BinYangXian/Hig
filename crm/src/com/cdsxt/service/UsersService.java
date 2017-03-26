package com.cdsxt.service;

import java.util.List;

import com.cdsxt.po.Users;
import com.cdsxt.vo.RoleVo;

public interface UsersService {
	Users findByUsername(String username);
	List<Users> findAll();
	void updateChooseRole(Integer id, Integer[] roleIds);
	List<RoleVo> findAllRoleInUsersToJson(Integer id);
}
