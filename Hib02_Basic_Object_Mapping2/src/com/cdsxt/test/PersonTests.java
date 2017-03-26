package com.cdsxt.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdsxt.po.Address;
import com.cdsxt.po.Person;
import com.cdsxt.po.PersonName;
import com.cdsxt.utils.HibUtil;

public class PersonTests {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		
		PersonName name = new PersonName();
		
		
		name.setFirstName("张");
		name.setLastName("三");
		person.setName(name);
		person.setAge(20);
		
		Address address = new Address();
		
		address.setProvince("四川");
		address.setCity("成都");
		address.setArea("高新区");
		
		person.setAddress(address);
		
		Session session = HibUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		
		session.close();
		
	}

}
