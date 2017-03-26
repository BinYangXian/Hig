package com.cdsxt.sell.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.sell.dao.DevCustomDao;
import com.cdsxt.sell.po.DevCustom;
import com.cdsxt.sell.po.SalesOpp;

@Repository
public class DevCustomDaoImpl implements DevCustomDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	//分页
	@SuppressWarnings("unchecked")
	@Override
	public List<DevCustom> findFroPage(Integer start,Integer row){
		Query query=this.getSession().createQuery("from DevCustom d");
//		query.setParameter("stateCode", stateCode).setFirstResult(start).setMaxResults(row);
		return query.setFirstResult(start).setMaxResults(row).list();
	}
	//分页根据状态码查找
	@SuppressWarnings("unchecked")
	@Override
	public List<DevCustom> findFroPage(Integer start,Integer row,Integer stateCode){
		Query query=this.getSession().createQuery("from DevCustom d where stateCode=:stateCode");
		return query.setParameter("stateCode", stateCode).setFirstResult(start).setMaxResults(row).list();
	}
	
	//通过ID查找
	@Override
	public DevCustom findById(Integer id){
		return (DevCustom)this.getSession().get(DevCustom.class, id);
	}
	//查找全部
	@SuppressWarnings("unchecked")
	@Override
	public List<DevCustom> findAll(){
		return this.getSession().createQuery("from DevCustom").list();
	}
	//查找总数
	@Override
	public long findCount(){
		return (long) this.getSession().createQuery("select count(id) from DevCustom").uniqueResult();
	}
	//查找总数，更加状态码
	@Override
	public long findCount(Integer stateCode){
		return (long)this.getSession().createQuery("select count(*) from DevCustom where stateCode = :stateCode").setParameter("stateCode", stateCode).uniqueResult();
	}

}
