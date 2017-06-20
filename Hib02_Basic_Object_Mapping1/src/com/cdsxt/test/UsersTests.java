package com.cdsxt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdsxt.po.Users;
import com.cdsxt.utils.HibUtil;

public class UsersTests {
	
	public static void main(String[] args) {
		
		Users users = new Users();
		users.setId(2);
		users.setAge(20);
		users.setUsername("admin");
		users.setPassword("admin");
		
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(users);
		tx.commit();
		
		session.close();
		
	}

}
