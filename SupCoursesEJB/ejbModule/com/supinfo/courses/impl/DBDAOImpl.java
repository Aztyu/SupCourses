package com.supinfo.courses.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.supinfo.courses.database.PersistenceManager;
import com.supinfo.courses.entity.Course;
import com.supinfo.courses.entity.User;
import com.supinfo.courses.interfaces.IDbDAO;
import com.supinfo.courses.utils.HashUtils;

public class DBDAOImpl implements IDbDAO{
	@Override
	public void initDB() {
		User user_test = new User();
		user_test.setUsername("test");
		try {
			user_test.setPassword(HashUtils.hashMD5("test"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Course sharepoint = new Course("Sharepoint"
				, "Learn every aspect of this powerful platform used to share documents in a professionnal environment"
				, "2017/02/06"
				, "2017/02/10");
		Course java = new Course("Java JSF"
				, "The introduction to a new way to create quickly and painlessly a modern website"
				, "2017/02/06"
				, "2017/02/22");
		Course linux = new Course("Linux server"
				, "Learn to install and maintain a simple Linux server to host your new projects"
				, "2017/02/20"
				, "2017/02/24");
		Course voip = new Course("VoiP Asterisk"
				, "Use your fresh Linux skill to deploy your own IPBX"
				, "2017/02/27"
				, "2017/03/03");
		
		try{
			EntityManager em = PersistenceManager.getEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			//Create user test
			em.persist(user_test);
			
			//Create test courses
			em.persist(sharepoint);
			em.persist(java);
			em.persist(linux);
			em.persist(voip);
			
			et.commit();
			em.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
