package com.cdsxt.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cdsxt.po.ClassInfo;
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
	
	@Test
	public void testFindAll(){
		
		ClassInfo info = (ClassInfo) this.session.get(ClassInfo.class, 7);
		Set<Student> ss = info.getStudents();//当使用ss时候，就会根据info的set的配置信息"cid"
		//（这里=7，配置集合）去找7班的所有学生。
		if(ss!=null && !ss.isEmpty()){
			for(Student s:ss){
				System.out.println("学生:"+s.getStuName()+"在"+info.getCname()+"班");
			}
		}
	}
	
	@Test
	public void testSave(){
		
		//保存数据   如果在一方里面持有多方的瞬时态对象  不能保存成功
		//如果需要保存成功 则应该在 一方的集合配置上添加上cascade="save-update"属性
		//瞬时态
		ClassInfo info = new ClassInfo();
		
		//瞬时态
		Student s1 = new Student();
		s1.setStuName("lisi");
		Student s2 = new Student();
		s2.setStuName("lisi1");
		Student s3 = new Student();
		s3.setStuName("lisi2");
		Student s4 = new Student();
		s4.setStuName("lisi3");
		
		info.setCname("HTML");
		
		Set<Student> ss = new HashSet<>();
		ss.add(s1);
		ss.add(s2);
		ss.add(s3);
		ss.add(s4);
		
		
		info.setStudents(ss);
		
		this.session.save(info);
	}
	@Test
	public void testSave1(){
		//去掉级联属性
		//如果是更新持久态数据  则cascade属性不需要
		ClassInfo info  = new ClassInfo();
		info.setCname("JavaScript");
		
		//将持久态的对象放入 瞬时态的一方的集合里面  进行保存
		Student s = (Student) this.session.get(Student.class, 4);
		
		Set<Student> ss = new HashSet<>();
		ss.add(s);
		
		info.setStudents(ss);
		
		this.session.save(info);
	}
	
	@Test
	public void testUpdate(){
		//一方的集合  默认就是 懒加载  只有使用的时候 才会去加载数据
		ClassInfo info = (ClassInfo) this.session.get(ClassInfo.class, 8);
		Set<Student> ss = info.getStudents();
		if(ss!=null && !ss.isEmpty()){
			for(Student s:ss){
				s.setStuName("zzzzz");
			}
		}
	}
	
	@Test
	public void testDelete(){
		//测试级联为  delete
		ClassInfo info = (ClassInfo) this.session.get(ClassInfo.class, 8);
		this.session.delete(info);
	}

	@Test
	public void testDelete1(){
		//测试all-delete-orphan
		ClassInfo info = (ClassInfo) this.session.get(ClassInfo.class, 7);
		Set<Student> ss = info.getStudents();
		if(ss!=null && !ss.isEmpty()){
			Iterator<Student> iterator = ss.iterator();
			while(iterator.hasNext()){
				Student s = iterator.next();
				if(s.getStuId() == 2){
					iterator.remove();
				}
			}
		}
	}
}
