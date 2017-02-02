package com.supinfo.courses.entity;

import java.io.Serializable;

public class UserCourse implements Serializable{
	private int Id;
	
	private User user;
	
	private Course course;
	
	public UserCourse(){};

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
