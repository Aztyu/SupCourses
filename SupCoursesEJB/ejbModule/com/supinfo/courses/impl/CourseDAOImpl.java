package com.supinfo.courses.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.supinfo.courses.database.PersistenceManager;
import com.supinfo.courses.entity.Course;
import com.supinfo.courses.entity.User;
import com.supinfo.courses.interfaces.ICourseDAO;

@Stateless
public class CourseDAOImpl implements ICourseDAO{

	@Override
	public List<Course> getAllCourse() {
		EntityManager em = null;
		try{
			em = PersistenceManager.getEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Course> cq = cb.createQuery(Course.class);
			Root<Course> course = cq.from(Course.class);
			List<Course> result = em.createQuery(cq).getResultList();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			if(em != null){
				em.close();
			}
		}
	}

}
