package com.cdsxt.sell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.sell.dao.DevCustomDao;
import com.cdsxt.sell.po.DevCustom;
import com.cdsxt.sell.service.DevcustomService;

@Service
@Transactional(readOnly=true)
public class DevcustomServiceImpl implements DevcustomService{
	
	@Autowired
	private DevCustomDao devCustomDao;
	
	//找到全部
	@Override
	public List<DevCustom> findFroPage(Integer start,Integer row){
		return devCustomDao.findFroPage(start, row);
	}
	//找到总数1
	@Override
	public int findCount(){
		return (int) devCustomDao.findCount();
	}
	//找到总数2
	public int findCount(Integer stateCode){
		return (int) devCustomDao.findCount(stateCode);
	}
	
}
