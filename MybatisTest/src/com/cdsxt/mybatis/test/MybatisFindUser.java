package com.cdsxt.mybatis.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.cdsxt.mybatis.po.User;

public class MybatisFindUser {
	/**
	 * 创建工厂
	 */
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		//定义配置文件
		String resource="SqlMapConfig.xml";
		//加载配置文件到输入流
		InputStream inputStream=Resources.getResourceAsStream(resource);
		sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
	}
	/**
	 * mybatis通过id查询用户信息
	 */
	@Test
	public void findUserById(){
		//sqlSessionFactory创建sqlsession
		SqlSession sqlSession=sqlSessionFactory.openSession();
		//通过sqlsession操作数据库
		//sqlSession.selectOne(arg0, arg1) 
		//arg0:User.xml中namespace+statement的id
		//arg1,指定传入参数
		User user= sqlSession.selectOne("test.findUserById",1);
		//关闭sqlsession
		sqlSession.close();
		System.out.println(user);
	}
}
