package com.ecommerce;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ecommerce.user.Catagory;

public class CategoryDao {
	
	private EntityManager entityManager = null;
	private EntityTransaction transaction = null;
      
	public boolean saveCategory(Catagory catagory ) {
		Entity_class entity_class = new  Entity_class();
		entityManager = entity_class.getEntityManager();
		
		transaction = entityManager.getTransaction();
		try {
	        transaction.begin();
	        entityManager.persist(catagory);
	        transaction.commit();
	        System.out.println("OK");
	        return true ;
	    } catch (Exception e) {
	        transaction.rollback();
	        return false ;
	    }
		
	}
	
	public List<Catagory> getCategories()
	{
		
		Entity_class entity_class = new  Entity_class();
		entityManager = entity_class.getEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		Query query = entityManager.createQuery("from Catagory");
	    List<Catagory> categoryList = query.getResultList();
	    transaction.commit();
	    //System.out.println(categoryList);
	    return categoryList;
	}
	
	public Catagory getCategoryById(int cid ) {
		Entity_class entity_class = new  Entity_class();
		entityManager = entity_class.getEntityManager();
		transaction = entityManager.getTransaction();
		
		Catagory cat = null ;
		try {
			transaction.begin();
			cat = entityManager.find(Catagory.class , cid);
			transaction.rollback();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return cat ;
	}
     
	
	
}
