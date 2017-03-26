package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.dao.MenuDAO;
import com.cdsxt.po.Menu;
import com.cdsxt.vo.MenuVo;

@Repository
public class MenuDAOImpl implements MenuDAO{

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> findAll() {
		Query query  = this.getSession().createQuery("from Menu m");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuVo> findAllToLeft() {
		Query query  = this.getSession().createQuery("select new com.cdsxt.vo.MenuVo(m.menuId,m.parent.menuId,m.menuName,m.menuUrl) from Menu m");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> findByIds(Integer[] menuIds) {
		Query query = this.getSession().createQuery("from Menu m where m.menuId in (:ids)");
		query.setParameterList("ids", menuIds);
		return query.list();
	}

}
