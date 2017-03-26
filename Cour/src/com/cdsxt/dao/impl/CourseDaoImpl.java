package com.cdsxt.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.po.Course;
import com.cdsxt.utils.HibUtil;

public class CourseDaoImpl implements CourseDao {

	@Override
	public void save(Course course) {
		// TODO Auto-generated method stub
		Session session = HibUtil.getSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() {
		Session session = HibUtil.getSession();
		Query query = session.createQuery("select s from Course s");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findByIds(Integer[] ids) {
		if(ids==null || ids.length<1){
			return new ArrayList<>();
		}
		//构建查询语句
		StringBuilder sb = new StringBuilder("select c from Course c where c.cid in (");
		for(int i=0;i<ids.length;i++){
			sb.append("?,");
		}
		sb.deleteCharAt(sb.length()-1).append(")");
		
		Query query = HibUtil.getSession().createQuery(sb.toString());
		for(int i=0;i<ids.length;i++){
			query.setInteger(i, ids[i]);
		}
		return query.list();
	}

}
