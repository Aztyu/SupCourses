package com.supinfo.courses.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Course implements Serializable{
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	private Date start_date;
	
	private Date end_date;
	
	public Course(){}

	public Course(String title, String description, String start, String end){
		this.title = title;
		this.description = description;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			this.start_date = new Date(sdf.parse(start).getTime());
		} catch (ParseException e) {
			this.start_date = new Date(System.currentTimeMillis());
		}
		try {
			this.end_date = new Date(sdf.parse(end).getTime());
		} catch (ParseException e) {
			this.end_date = new Date(System.currentTimeMillis());
		}
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
}
