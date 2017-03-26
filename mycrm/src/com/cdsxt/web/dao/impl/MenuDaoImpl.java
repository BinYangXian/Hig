package com.cdsxt.web.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.web.dao.MenuDao;
import com.cdsxt.web.po.Menu;
import com.cdsxt.web.vo.MenuVo;

@Repository
public class MenuDaoImpl implements MenuDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> findAll(){
		return this.getSession().createQuery("from Menu").list();
	}
	
	@Override
	public Menu findById(Integer id){
		return (Menu) this.getSession().get(Menu.class, id);
	}
	
	
	
	

	
	
	
}
