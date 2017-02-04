package com.supinfo.courses.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.supinfo.courses.entity.Course;
import com.supinfo.courses.entity.User;
import com.supinfo.courses.interfaces.ICourseDAO;

@ManagedBean(name="courseBean")
@RequestScoped
public class CourseBean {
	private List<Course> courses = null;
	
	@EJB
	ICourseDAO courseDAO;
	
	public CourseBean() {}

	public List<Course> getCourses() {
		if(courses == null){
			this.courses = courseDAO.getAllCourse();
		}
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
