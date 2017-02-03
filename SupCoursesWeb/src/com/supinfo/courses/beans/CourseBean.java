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
	private List<Course> courses;
	
	@EJB
	ICourseDAO courseDAO;
	
	public CourseBean() {
		this.courses = courseDAO.getAllCourse();
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
}
