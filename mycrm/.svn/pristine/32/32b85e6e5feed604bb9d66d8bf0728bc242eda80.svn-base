package com.cdsxt.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.web.dao.StaffDao;
import com.cdsxt.web.po.Staff;
import com.cdsxt.web.service.StaffService;
import com.cdsxt.web.vo.StaffVo;

@Service
@Transactional(readOnly=true)
public class StaffServiceImpl implements StaffService{
	
	
	@Autowired
	private StaffDao staffDao;
	
	
	//分页查找
	@Override
	public List<StaffVo> findForPage(int startRow,int pageRow){
		List<StaffVo> staffVos=new ArrayList<StaffVo>();
		List<Staff> staffs=staffDao.findFroPage(startRow, pageRow);
		for (Staff s : staffs) {
			StaffVo staffVo;
			if(s.getUser()!=null&&s.getUser().getRoles()!=null){
				staffVo=new StaffVo(s,s.getUser().getRoles().get(0).getRoleName());
			}else {
				staffVo=new StaffVo(s);
			}
			if(s.getUser()!=null){
				staffVo.setUserId(s.getUser().getId());
				staffVo.setUserName(s.getUser().getUserName());
			}
			staffVos.add(staffVo);
		}
		return staffVos;
	}
	//找到总条数
	@Override
	public int findCount(){
		return (int) this.staffDao.findCount();
	}
	
}
