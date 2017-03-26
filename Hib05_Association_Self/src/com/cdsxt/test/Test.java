package com.cdsxt.test;

import java.util.Set;

import org.hibernate.Session;

import com.cdsxt.po.Dept;
import com.cdsxt.po.Emp;
import com.cdsxt.utils.HibUtil;

public class Test {
	
	@org.junit.Test
	public void testFindAll(){
		Session session = HibUtil.getSession();
		Dept dept = (Dept) session.get(Dept.class, 20);
		
		System.out.println(dept.getDname());
		
		Set<Emp> emps = dept.getEmps();
		if(emps!=null && !emps.isEmpty()){
			for(Emp emp:emps){
				System.out.println(emp.getEname()+"\t"+emp.getDept().getDname()+"\t"+emp.getManager().getEname());
			}
		}
		
		
		session.close();
		
		
	}

}
