package com.cdsxt.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.cdsxt.dao.UsersDao;
import com.cdsxt.po.Users;
//!!!!!!!!!!!!!-这里的事务都应该转移到service层-!!!!!!!!!!!!!
@Repository
@Transactional(readOnly=true) //类里的所有方法都有事务，默认为(propagation=Propagation.REQUIRED),现改之
public class UsersDaoImpl implements UsersDao {
	private TransactionTemplate transactionTemplate;
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		//得到当前线程中的session
		//一定要配合事务管理器，才能成功得到
		return this.sessionFactory.getCurrentSession();//注意这里使用的getCurrentSession方法，而非getSession什么的
	}
	@Transactional(propagation=Propagation.REQUIRED)//将只读的事务传播类型重写为REQUIRED
	public void save(Users users){
		this.getSession().save(users);
	}
	//编程式事务之事务模板
	public void delete(){
		this.transactionTemplate.execute(new TransactionCallback<Object>() {

			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				//写代码
				//都是持有事务的
				return null;
			}
		});
	}
}
