package com.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ecommerce.user.User;

public class Entity_class {

		
		private EntityManagerFactory entityManagerFactory = null;
		private EntityManager entityManager = null;
		private EntityTransaction transaction = null;

		public EntityManager getEntityManager() {
			entityManagerFactory = Persistence.createEntityManagerFactory("ecommerce");
			entityManager = entityManagerFactory.createEntityManager();
			return entityManager;
		}
		
		public boolean saveuser(User user) {
			entityManager = getEntityManager();
			transaction = entityManager.getTransaction();
			try {
		        transaction.begin();
		        entityManager.persist(user);
		        transaction.commit();
		        System.out.println("OK");
		        return true ;
		    } catch (Exception e) {
		        transaction.rollback();
		        return false ;
		    }
		}
	
		public User getUserByEmailPass(String email , String password) {
			User user = null;
			
			try {
				
				entityManager = getEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				Query query= entityManager.createQuery("from User where useremail =: e and userPassword =: p");
				query.setParameter("e", email);
				query.setParameter("p", password);
				user = (User) query.getSingleResult();
		        transaction.commit();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
		}
       
		
	}
   
	
