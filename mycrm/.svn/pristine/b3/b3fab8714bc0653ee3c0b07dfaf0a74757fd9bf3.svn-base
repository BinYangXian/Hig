package com.cdsxt.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdsxt.web.dao.RoleDao;
import com.cdsxt.web.po.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	//找到所有角色
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAllRole(){
		String hql="from Role r order by r.roleId";
		return this.getSession().createQuery(hql).list();
	}
	//根据ID找到角色
	@Override
	public Role findById(Integer roleId){
		return (Role) this.getSession().get(Role.class, roleId);
	}
	//根据名字找到角色
	@Override
	public Role findByName(String name){
		Query query=this.getSession().createQuery("from Role r where r.roleName=:roleName");
		query.setParameter("roleName", name);
		return (Role) query.uniqueResult();
	}
	//更新角色
	@Override
	public void updateRole(Role role){
		this.getSession().update(role);
	}
	//保存角色
	@Override
	public void addRole(Role role){
		this.getSession().save(role);
	}
	//删除角色
	@Override
	public void deleteRole(Role role){
		this.getSession().delete(role);
	}
	//查询总条数
	@Override
	public Long findAllCount(){
		Query query=this.getSession().createQuery("select count(*) from Role r");
		return (Long) query.uniqueResult();
	}
	//分页查询
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findForPage(int startRow,int pageRow){
		Query query=this.getSession().createQuery("from Role");
		query.setFirstResult(startRow);
		query.setMaxResults(pageRow);
		return query.list();
	}
}
