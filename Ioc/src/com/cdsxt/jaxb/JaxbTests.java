package com.cdsxt.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cdsxt.jaxb.po.Users;

public class JaxbTests {

	public static void main(String[] args) throws Exception {
		/**
		 * JAXB   (Java And XML Binding)  通常用在 web service
		 * 
		 * 缺点  就是要满足 转换的对象和xml文件之间 一一对应
		 * 
		 */
		
		//创建一个转换上下文
		JAXBContext context = JAXBContext.newInstance(Users.class);
		
		//创建序列化器或者反序列化器
		//
		
		Marshaller marshaller = context.createMarshaller();
		
		
		//创建对象
		Users users = new Users();
		users.setId(1);
		users.setUsername("lisi");
		users.setPassword("123123");
		users.setEmail("lisi@lisi.com");
		
		marshaller.marshal(users, System.out);
		
		
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		
		Object object = unmarshaller.unmarshal(new File("src/Users.xml"));
		System.out.println();
		Users u  = (Users)object;
		System.out.println(object);
		
		System.out.println(u.getUsername());
	}
}
