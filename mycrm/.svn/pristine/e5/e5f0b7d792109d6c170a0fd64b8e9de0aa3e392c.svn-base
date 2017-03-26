package com.cdsxt.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.web.dao.UserDao;
import com.cdsxt.web.po.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	//找到所有用户
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll(){
		String hql="from User u";
		return this.getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findForPage(int startPage,int rowPage){
		String hql="from User u";
		return this.getSession().createQuery(hql).setFirstResult(startPage).setMaxResults(rowPage).list();
	}
	
	//根据用户名找到用户
	@Override
	public User findByUserName(String userName){
		String hql="from User u where u.userName=:userName";
		Query query=this.getSession().createQuery(hql);
		query.setParameter("userName",userName);
		return (User) query.uniqueResult();
	}
	//根据id查找用户
	@Override
	public User findById(Integer id){
		return (User) this.getSession().get(User.class, id);
	}
	
	//修改用户
	@Override
	public void updateUser(User user){
		this.getSession().update(user);
	}
	
	//分页找到所有用户
	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll(int startRow,int pageRow){
		return this.getSession().createQuery("from User").setFirstResult(startRow).setMaxResults(pageRow).list();
	}
	
	//保存用户
	@Override
	public void addUser(User user){
		this.getSession().save(user);
	}
	
	
	//找到总数
	@Override
	public Long findCount(){
		return (Long) this.getSession().createQuery("select count(*) from User u").uniqueResult();
	}
	//删除用户
	@Override
	public void deleteUser(User user){
		this.getSession().delete(user);
	}
	

	
}
