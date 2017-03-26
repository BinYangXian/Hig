package com.cdsxt.test;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;
import com.cdsxt.vo.EmpVo;

public class TestQuery {

	private Session session;
	
	@Before
	public void before(){
		this.session = HibUtil.getSession();
	}
	
	@After
	public void after(){
		this.session.close();
	}
	
	/**
	 * 简单测试
	 * 
	 * HQL   Hibernate Query language （对象导航）和sql语句很类似  但是它查询的是  对象  而不是表  只要遇到对象或者
	 * 		  类属性的时候  就需要区分大小写   毕竟不是sql语句 多以对函数的支持力度不大
	 */
	@Test
	public void testSimpleQuery(){
		//对象查询  使用的是 Query接口  SQLQuery
		//select e from Emp e;
		Query query  = this.session.createQuery("from Emp e");
		List<Emp> emps = query.list();
		System.out.println(emps.size());
		
	}
	
	//测试带参数
	@Test
	public void testQueryWithParam(){
		Query query  = this.session.createQuery("from Emp e where e.dept.deptno=:deptno and e.sal>:sal");
		//设置参数   起始位置是从0开始   传统的JDBC是从1开始
		//命名参数
//		query.setInteger(0, 20);
		
		//设置命名参数
		query.setParameter("deptno", 20);
		query.setParameter("sal", 2000d);
		List<Emp> emps = query.list();
		System.out.println(emps.size());
		
	}
	
	//测试参数是数组的时候
	@Test
	public void testQueryWithArrayParam(){
		Query query = this.session.createQuery("from Emp e where e.empno in (:ids)");
		query.setParameterList("ids", new Integer[]{7839,7521,9527});
		
		List<Emp> emps = query.list();
		System.out.println(emps.size());
	}
	
	@Test
	public void testQueryWithLike(){
		Query query = this.session.createQuery("from Emp e where e.ename like :like");
		query.setParameter("like", "%A%");
		System.out.println(query.list().size());
	}
	
	@Test
	public void testQueryRetuenSimpleList(){
		//对象查询  使用的是 Query接口  SQLQuery
		//select e from Emp e;
		Query query  = this.session.createQuery("from Emp e");
		List<Emp> emps = query.list();
		System.out.println(emps.size());
	}
	@Test
	public void testQueryRetuenColumn(){
		//对象查询  使用的是 Query接口  SQLQuery
		//select e from Emp e;
		//返回部分列 列数>=2  使用的是用  Object[] 数组
		Query query  = this.session.createQuery("select e.empno,e.ename from Emp e");
		List<Object[]> emps = query.list();
		for(Object[] e:emps){
			System.out.println(e);
		}
		//System.out.println(emps.size());
	}
	
	@Test
	public void testQueryRetuenOneColumn(){
		//对象查询  使用的是 Query接口  SQLQuery
		//select e from Emp e;
		//返回单一的列  就是具体的数据类型  如果不知道  就用Object接受
		Query query  = this.session.createQuery("select e.ename from Emp e");
		List<String> emps = query.list();
		for(String e:emps){
			System.out.println(e);
		}
		//System.out.println(emps.size());
	}
	
	@Test
	public void testQueryRetuenMap(){
		//测试返回map
		Query query  = this.session.createQuery("select new Map(e.empno as empno,e.ename as ename,e.dept.dname as dname) from Emp e");
		List<Map<String,Object>> emps = query.list();
		
		for(Map<String,Object> e:emps){
			System.out.println(e.get("empno")+"\t"+e.get("ename")+"\t"+e.get("dname"));
		}
		//System.out.println(emps.size());
	}
	@Test
	public void testQueryRetuenVo(){
		//测试返回Vo
		Query query  = this.session.createQuery("select new com.cdsxt.vo.EmpVo(e.empno,e.ename,e.job) from Emp e");
		List<EmpVo> emps = query.list();
		for(EmpVo e:emps){
			System.out.println(e);
		}
	}
	
	@Test
	public void testQueryRetuenSingle(){
		//测试返回单一结果
		Query query  = this.session.createQuery("select e from Emp e where e.empno=?").setParameter(0, 7369);
		//返回单行数据
		//uniqueResult()  返回的结果条数<=1
		Emp emp = (Emp) query.uniqueResult();
		System.out.println(emp.getEname());
	}
	@Test
	public void testQueryRetuenSingleData(){
		//测试返回一行一列的数据
		Query query  = this.session.createQuery("select count(1) from Emp e");
		//返回单行数据
		//uniqueResult()  返回的结果条数<=1
		Long count = (Long) query.uniqueResult();
		System.out.println(count);
	}
	
	@Test
	public void testQueryPage(){
		//测试分页
		Query query  = this.session.createQuery("select e from Emp e");
		query.setFirstResult(10);
		query.setMaxResults(10);
		List<Emp> emps = query.list();
		System.out.println(emps.size());
	}
	
	@Test
	public void testSqlQuery(){
		SQLQuery query = session.createSQLQuery("select * from emp e").addEntity(Emp.class);
		List<?> list = query.list();
		System.out.println(list.get(0));
	}
}
