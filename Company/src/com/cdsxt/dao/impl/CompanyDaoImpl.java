package com.cdsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;

import com.cdsxt.dao.CompanyDao;
import com.cdsxt.po.Company;
import com.cdsxt.utils.HibUtil;

public class CompanyDaoImpl implements CompanyDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findByParentId(Integer parent) {
		Query query = null;
		if(parent == null){
			query = HibUtil.getSession().createQuery("from Company c where c.parent.id is null");
		}else{
			query = HibUtil.getSession().createQuery("from Company c where c.parent.id=:id");
			query.setParameter("id", parent);
		}
		return query.list();
	}

	@Override
	public Company findById(Integer id) {
		return (Company) HibUtil.getSession().get(Company.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> findAll() {
		return HibUtil.getSession().createQuery("from Company c").list();
	}

}
