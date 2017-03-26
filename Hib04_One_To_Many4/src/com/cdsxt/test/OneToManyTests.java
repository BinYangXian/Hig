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

import com.cdsxt.po.ClassInfo;
import com.cdsxt.po.Student;
import com.cdsxt.utils.HibUtil;

/**
 * 中午的作业
 * 
 * 测试一对多中的增删查改情况
 * 
 * 查询：修改cascade属性的值  看一下对查询的关系是否有影响
 * 
 * 新增：修改cascade属性的值  看一下：
 * 		1）、集合为空的情况  能否保存成功
 * 		2）、集合中保存的瞬时态对象  是否能保存成功
 * 		3）、当集合中是持久态对象的时候   是否能保存成功
 * 		4）、当集合中 既有瞬时态又有持久态的时候   是否可以保存成功
 * 
 * 更新：修改cascade属性的值  看一下：
 * 		1）、删除原有的集合中的数据  看一下是否有影响
 * 		2）、将原有的集合替换为 新的集合  看一下是否有影响
 * 		3）、添加瞬时态对象  是否能更新成功
 * 		4）、添加一个持久态对象  看一下是否能更新成功
 * 		5）、修改集合中的其中一个或多个对象  看一下是否有影响
 * 
 * 删除：修改cascade属性的值  看一下：
 * 		1）、删除集合中的一个对象
 * 		2）、将集合去掉 置空
 * 		3）、删除持有集合的对象  看一下对子记录是否有影响
 * 
 *
 */

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
		Set<Student> ss = info.getStudents();
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
	
	
	
	
	//测试新增数据
	
	@Test
	public void testSaveClassInfo(){
		//cascade= 所有情况都可以，因为这里是直接将瞬时态的info，通过save后，放入了session管道中，变成了持久态 
		ClassInfo info  =new ClassInfo();
		
		info.setCname("JSP");
		
		this.session.save(info);
	}
	
	@Test
	public void testSaveClassInfoAndStudent(){
		//cascade= （"all-delete-orphan"、save-update、all）都是能添加成功的，其余不能。
		ClassInfo info  =new ClassInfo();
		
		info.setCname("JSP");
		
		Student s = new Student();
		s.setStuName("admin");
		Set<Student> ss = new HashSet<>();
		ss.add(s);
		
		info.setStudents(ss);
		
		this.session.save(info);
	}
	
	@Test
	public void testSaveClassInfoAndStudent1(){
		//测试 在对象中的集合有持久态数据的时候(表示多方的数据)，一般而言，对于cascade="none"都行的话，其余所有选项也可以。
		//这里就是如此。
		ClassInfo info  =new ClassInfo();
		
		info.setCname("JSP");
		
		Student s = (Student) this.session.get(Student.class, 5);
		
		Set<Student> ss = new HashSet<>();
		ss.add(s);
		
		info.setStudents(ss);
		
		this.session.save(info);
	}
	
	@Test
	public void testSaveStudent(){
		
		for(int i=0;i<10;i++){
			Student s = new Student();
			s.setStuName("aaaaa"+i);
			this.session.save(s);
		}
	}
	
	@Test
	public void testSave2(){
		ClassInfo info = (ClassInfo) this.session.get(ClassInfo.class, 19);
		List<Student> ss = this.session.createQuery("select u from Student u where u.stuId>6").list();
		
		info.getStudents().addAll(ss);//info.getStudents() 这半句也会触发sql语句：select * from test_student s where s.cid=19 
		
		this.session.update(info);//当inverse="true" 既“一”方放弃关系维护 ，可以省略多余的数据库操作，因为此时
		//“多”方的外键会ss处于持久态，会自动更新。
	}
	
}
