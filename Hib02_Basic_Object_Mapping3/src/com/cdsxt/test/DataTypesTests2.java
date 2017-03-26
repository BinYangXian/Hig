package com.cdsxt.test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.LobCreator;

import com.cdsxt.po.DataTypes;
import com.cdsxt.utils.HibUtil;

public class DataTypesTests2 {
	
	public static void main(String[] args) throws Exception {
		
		DataTypes types = new DataTypes();
		
		types.setTestChar('A');
		types.setTestUtilDate(new Date());
		types.setTestString("test");
		types.setId(1);
		
		// 获取Lob创建器
		
		Session session = HibUtil.getSession();
		
		LobCreator creator = Hibernate.getLobCreator(session);
		//创建Blob
		Blob blob = creator.createBlob(new FileInputStream(new File("D:/aaaaa.jpg")),880640 );
		
		Clob clob = creator.createClob("hkjshkjahsdlkfhksajfdhkjsadhfkjsdhfksdhfkljalskjdf");
		
		types.setTestClob(clob);
		types.setTestBlob(blob);
		
		Transaction tx = session.beginTransaction();
		session.save(types);
		tx.commit();
		
		session.close();
		
	}

}
