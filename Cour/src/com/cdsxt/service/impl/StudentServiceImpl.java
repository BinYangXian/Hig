package com.cdsxt.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cdsxt.dao.CourseDao;
import com.cdsxt.dao.StudentDao;
import com.cdsxt.dao.impl.CourseDaoImpl;
import com.cdsxt.dao.impl.StudentDaoImpl;
import com.cdsxt.po.Course;
import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;

public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao = new StudentDaoImpl();
	
	private CourseDao courseDao = new CourseDaoImpl();

	@Override
	public void save(Student student) {
		this.studentDao.save(student);
	}

	@Override
	public List<Student> findAll() {
		return this.studentDao.findAll();
	}

	@Override
	public void choose(Integer id, Integer[] ids) {
		// TODO Auto-generated method stub
		Student student = this.studentDao.findByStuId(id);
		
		if(student!=null){
			//操作
			
			//得到对应的学生
			
			//得到里面的课程列表
			Set<Course> cs = student.getCourses();
			if(cs==null){
				cs = new HashSet<>();
			}
			
			//清空以前的数据 
			
			cs.clear();
			
			//重新建立联系
			cs.addAll(this.courseDao.findByIds(ids));
			
			//设置课程
			student.setCourses(cs);
			
			studentDao.update(student);
		}
	}

	@Override
	public Integer[] findAllCourse(Integer id) {
		// TODO Auto-generated method stub
		Student student = this.studentDao.findByStuId(id);
		//判断有没有学生 
		if(student==null){
			return new Integer[]{};
		}
		//判断有没有课程
		Set<Course> cs = student.getCourses();
		if(cs == null || cs.isEmpty()){
			return new Integer[]{};
		}
		
		Integer[] ids = new Integer[cs.size()];
		int i=0;
		for(Course c:cs){
			ids[i] = c.getCid();
			i++;
		}
		
		return ids;
	}

}
