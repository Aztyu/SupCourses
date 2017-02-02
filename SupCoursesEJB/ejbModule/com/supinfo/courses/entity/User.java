package com.supinfo.courses.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String username;
	
	private String password;
	
	@OneToMany
	private List<UserCourse> course_taken;
	
	public User(){}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserCourse> getCourse_taken() {
		return course_taken;
	}

	public void setCourse_taken(List<UserCourse> course_taken) {
		this.course_taken = course_taken;
	}
}
