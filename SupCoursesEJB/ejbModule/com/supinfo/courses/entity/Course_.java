package com.supinfo.courses.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Course.class)
public class Course_ {
	public static volatile SingularAttribute<Course, Integer> Id;
	public static volatile SingularAttribute<Course, String> title;
	public static volatile SingularAttribute<Course, String> description;
	public static volatile SingularAttribute<Course, Date> start_date;
	public static volatile SingularAttribute<Course, Date> end_date;
}
