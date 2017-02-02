package com.supinfo.courses.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.supinfo.courses.database.PersistenceManager;
import com.supinfo.courses.entity.User;
import com.supinfo.courses.entity.User_;
import com.supinfo.courses.interfaces.IUserDAO;
import com.supinfo.courses.utils.HashUtils;

import jdk.jfr.events.ExceptionThrownEvent;

@Stateless
public class UserDAOImpl implements IUserDAO{

	@Override
	public void createUser(User user){
		String hashed_password; 
		try{
			hashed_password = HashUtils.hashMD5(user.getPassword());
			user.setPassword(hashed_password);
		}catch(Exception ex){
			ex.printStackTrace();
		}

		try{
			EntityManager em = PersistenceManager.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(user);
			et.commit();
			em.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public User getUser(String username, String password) {
		String hashed_password; 
		try{
			hashed_password = HashUtils.hashMD5(password);
			password = hashed_password;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		
		EntityManager em = null;
		try{
			em = PersistenceManager.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> user = cq.from(User.class);
			cq.where(cb.and(cb.equal(user.get(User_.password), password), cb.equal(user.get(User_.username), username)));
			User result = em.createQuery(cq).getSingleResult();
			et.commit();
			return result;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			if(em != null){
				em.close();
			}
		}
	};
}
