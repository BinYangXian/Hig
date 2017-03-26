package com.cdsxt.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Student;
import com.cdsxt.service.StudentService;

@Controller
@Scope("prototype")
public class StudentAction {
	private Student  student;
	private Integer[] ids;
	private List<Student> students;
	@Autowired
	private StudentService studentService;
	public String findAll(){
		this.students=studentService.findAll();
		return "findAll";
	}
	public String save(){
		studentService.addStudent(student);
		return "save-success";
	}
	public String findAllCourse(){
		this.ids=studentService.findAllCourseByStuId(student.getStuId());
		return "findAllCourse";
	}
	public String choose(){
		if(student!=null&&ids!=null){
			studentService.choose(student.getStuId(),ids);
		}
		return "choose";
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
}
