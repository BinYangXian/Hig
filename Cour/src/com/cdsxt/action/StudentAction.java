package com.cdsxt.action;

import java.util.List;

import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;
import com.cdsxt.service.impl.StudentServiceImpl;

public class StudentAction {

	private StudentService studentService = new StudentServiceImpl();
	
	private Student student;
	
	private List<Student> students;
	
	private Integer []ids;
	
	
	public String findAll(){
		this.students = this.studentService.findAll();
		return "findAll";
	}
	
	public String save(){
		if(this.student!=null){
			this.studentService.save(student);
		}
		return "save-success";
	}
	
	public String choose(){
		Integer id = null;
		if(this.student!=null){
			id = this.student.getStuId();
		}
		if(id!=null){
			this.studentService.choose(id,ids);
		}
		return "choose";
	}
	
	//查询该学生对应的选中的课程
	public String findAllCourse(){
		Integer id = null;
		if(this.student!=null){
			id = this.student.getStuId();
		}
		if(id !=null){
			this.ids = this.studentService.findAllCourse(id);
		}
		return "findAllCourse";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
}
