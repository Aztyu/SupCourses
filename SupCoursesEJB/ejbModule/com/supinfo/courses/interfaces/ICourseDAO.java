package com.supinfo.courses.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.supinfo.courses.entity.Course;

@Remote
public interface ICourseDAO {
	public List<Course> getAllCourse();
}
