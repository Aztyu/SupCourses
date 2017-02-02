package com.supinfo.courses.entity;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserCourse.class)
public class UserCourse_ {
	public static volatile SingularAttribute<UserCourse, Integer> Id;
	public static volatile SingularAttribute<UserCourse, User> user;
	public static volatile SingularAttribute<UserCourse, Course> course;
}
