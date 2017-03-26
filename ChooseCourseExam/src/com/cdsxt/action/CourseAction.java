package com.cdsxt.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cdsxt.po.Course;
import com.cdsxt.service.CourseService;
@Controller
@Scope("prototype")
public class CourseAction {
	@Autowired
	private CourseService courseService;
	private Course course;
	private List<Course> courses;
	
	
	public Course getCourse() {
		return course;
	}

	public String choose(){
		this.findAll();
		return "choose";
	}
	public void setCourse(Course course) {
		this.course = course;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


	public String findAll(){
		this.courses = this.courseService.findAll();
		return "findAll";
	}
	
	
	public String save(){
		if(this.course!=null){
			this.courseService.addCourse(course);
		}
		return "save-success";
	}
}
