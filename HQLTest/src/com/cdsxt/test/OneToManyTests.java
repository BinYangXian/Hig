package com.cdsxt.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cdsxt.po.Classes;
import com.cdsxt.po.Student;
import com.cdsxt.utils.HibUtil;

public class OneToManyTests {
	
	private Session session;
	
	private Transaction tx ;
	
	@Before
	public void before(){
		this.session = HibUtil.getSession();
		this.tx = session.beginTransaction();
	}
	@After
	public void after(){
		this.tx.commit();
		this.session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testFindAll(){
		
		List<Student> ss = HibUtil.getSession().createQuery("from Student").list();  
		for (Student student : ss) {
			System.out.println(student);
		}
		System.out.println("**********************缓存测试分割线*************************");
		List<Student> ss2 = HibUtil.getSession().createQuery("from Student").list();  
		for (Student student : ss2) {
			System.out.println(student);
		}
/*		Classes info = (Classes) HibUtil.getSession().createQuery("from Classes").list().get(1);  
		Set<Student> ss = info.getStudents();
//		System.out.println(ss.toArray());
		for (Student student : ss) {
			System.out.println(student);
		}
*/		/*Student info = (Student) HibUtil.getSession().createQuery("from Student").list().get(0);  
		Classes ss = info.getClasses();
		System.out.println(ss);*/
		
	/*	//缓存测试
			List<Student> ss = HibUtil.getSession().createQuery("from Student").list();  
		for (Student student : ss) {
			System.out.println(student);
		}
		System.out.println("**********************缓存测试分割线*************************");
		Iterator<Student> c=session.createQuery("from Student").iterate();  
		while(c.hasNext()){
			System.out.println(c.next());
		}*/
	}
	@Test
	public void testFind(){
		String hql="select c.name,count(s) from Classes c join c.students s group by c.name" ;  
		List students=session.createQuery(hql).list();  
		System.out.println(students);
	}
	@Test
	public void testSave(){
		//测试保存
		Classes c = new Classes();
		c.setName("c++");
		
		Student s1 = new Student();
		s1.setName("三");
		Student s2 = new Student();
		s2.setName("思");
		
		s1.setClasses(c);
		s2.setClasses(c);
		Set<Student> ss =new HashSet<>();
		ss.add(s1);
		ss.add(s2);
		
		c.setStudents(ss);
		session.save(c);
	}
	@Test
	public void testSave1(){
		//去掉级联属性
		//如果是更新持久态数据  则cascade属性不需要
		Classes info  = new Classes();
		info.setName("c++");
		
		//将持久态的对象放入 瞬时态的"一"方的集合里面  进行保存
		Student s = (Student) this.session.get(Student.class, 7);
		System.out.println("******************"+s);
		Set<Student> ss = new HashSet<>();
		ss.add(s);
		
		info.setStudents(ss);
		
		this.session.save(info);
	}
	
	@Test
	public void testUpdate(){
		//一方的集合  默认就是 懒加载  只有使用的时候 才会去加载数据
		Classes info = (Classes) this.session.get(Classes.class, 8);
		Set<Student> ss = info.getStudents();
		if(ss!=null && !ss.isEmpty()){
			for(Student s:ss){
				s.setName("zzzzz");
			}
		}
	}
	
	@Test
	public void testDelete(){
		//测试级联为  delete
		Classes info = (Classes) this.session.get(Classes.class, 8);
		this.session.delete(info);
	}

	@Test
	public void testDelete1(){
		//测试all-delete-orphan
		Classes info = (Classes) this.session.get(Classes.class, 7);
		Set<Student> ss = info.getStudents();
		if(ss!=null && !ss.isEmpty()){
			Iterator<Student> iterator = ss.iterator();
			while(iterator.hasNext()){
				Student s = iterator.next();
				if(s.getId() == 2){
					iterator.remove();
				}
			}
		}
	}
}
