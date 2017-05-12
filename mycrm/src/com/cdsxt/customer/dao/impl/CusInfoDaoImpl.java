package com.cdsxt.customer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.customer.dao.CusInfoDao;
import com.cdsxt.customer.po.CrmCusArea;
import com.cdsxt.customer.po.CrmCusLevel;
import com.cdsxt.customer.po.CrmCustomer;
import com.cdsxt.customer.po.CusLinkman;
@Repository
public class CusInfoDaoImpl implements CusInfoDao{
	@Autowired
	private SessionFactory sessionFactory;
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	@Override
	public List<CrmCustomer> findAllCustomer() {
		Query query = this.getSession().createQuery("from CrmCustomer c");
		return query.list();
	}

	@Override
	public void addCustomer(CrmCustomer c) {
		//由于c需要与已有的数据object、object2、object3建立关联（因为c维护与之的关系，含有它们的引用），所以需要
		Query query=this.getSession().createQuery("select c from CrmCusArea c where c.areaName=:areaName");
		query.setParameter("areaName", c.getCrmCusArea().getAreaName());
		Object object = query.list().get(0);
//		this.getSession().save(object);//已经是持久态的对象，不需要save。
		
		Query query2=this.getSession().createQuery("select c from CrmCusLevel c where c.levelName=:levelName");
		query2.setParameter("levelName", c.getCrmCusLevel().getLevelName());
		Object object2 = query2.list().get(0);
		
		Query query3=this.getSession().createQuery("select c from CusLinkman c where c.linkmanName=:linkmanName");
		query3.setParameter("linkmanName", c.getCusLinkman().getLinkmanName());
		Object object3 = query3.list().get(0);
		//把具有完成数据的持久态对象，更新到当前的 CrmCustomer 对象c中。
		c.setCrmCusArea((CrmCusArea)object);
		c.setCrmCusLevel((CrmCusLevel)object2);
		c.setCusLinkman((CusLinkman)object3);
		//保存瞬时态的c；
		this.getSession().save(c);	
		c.setCusNum(100+c.getCusId()+"");//偷懒通过id生成客户编号
		this.getSession().update(c);	
		
	}

	@Override
	public void deleCustomer(Integer i) {
		CrmCustomer c = (CrmCustomer) this.getSession().get(CrmCustomer.class, i);
		if(c!=null){
			this.getSession().delete(c);
		}
	}

	@Override
	public void updateCustomer(Integer cusId, CrmCustomer crmCustomer) {
		CrmCustomer c = (CrmCustomer) this.getSession().get(CrmCustomer.class, cusId);
		if(c!=null){
			this.getSession().update(crmCustomer);
		}
	}
	@Override
	public List<String> findAllCrmCusAreaNames() {
		Query query = this.getSession().createQuery("select c.areaName from CrmCusArea c");
		return query.list();
	}
	@Override
	public List<String> findAllLevelName() {
		Query query = this.getSession().createQuery("select c.levelName from CrmCusLevel c");
		return query.list();
	}
	@Override
	public List<String> findAllLinkmanNames() {
		Query query = this.getSession().createQuery("select c.linkmanName from CusLinkman c");
		return query.list();
	}
	@Override
	public CrmCustomer findCusDetailInfo(Integer cusId) {
		return (CrmCustomer) this.getSession().get(CusLinkman.class, cusId);
	}

}
