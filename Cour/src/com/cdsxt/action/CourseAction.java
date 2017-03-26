package com.cdsxt.action;

import java.util.List;

import com.cdsxt.po.Course;
import com.cdsxt.service.CourseService;
import com.cdsxt.service.impl.CourseServiceImpl;

public class CourseAction {
	
	private CourseService courseService = new CourseServiceImpl();
	private Course course;
	private List<Course> courses;
	
	
	public String findAll(){
		this.courses = this.courseService.findAll();
		return "findAll";
	}
	
	public String choose(){
		this.findAll();
		return "choose";
	}
	
	public String save(){
		if(this.course!=null){
			this.courseService.save(course);
		}
		return "save-success";
	}
	
	public Course getCourse() {
		return course;
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

}
