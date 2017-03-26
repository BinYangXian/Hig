package com.cdsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdsxt.dao.StudentDao;
import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;
@Service
@Transactional(readOnly=true)
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> findAll() {
		return this.studentDao.findAll();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void update(Student student) {
		this.studentDao.update(student);
	}

	@Override
	public Integer[] findAllCourseByStuId(Integer id) {
		return this.studentDao.findAllCourseByStuId(id);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public void addStudent(Student s) {
		this.studentDao.addStudent(s);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void choose(Integer stuId, Integer[] ids) {
		this.studentDao.updateChoose( stuId, ids);
	}

}
