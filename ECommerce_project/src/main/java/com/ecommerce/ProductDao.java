package com.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ecommerce.user.Catagory;
import com.ecommerce.user.Product;

public class ProductDao {

	private EntityManager entityManager = null;
	private EntityTransaction transaction = null;
	
	public boolean saveProduct(Product product ) {
		Entity_class entity_class = new  Entity_class();
		entityManager = entity_class.getEntityManager();
		
		transaction = entityManager.getTransaction();
		try {
	        transaction.begin();
	        entityManager.persist(product);
	        transaction.commit();
	        return true ;
	    } catch (Exception e) {
	        transaction.rollback();
	        return false ;
	    }
		
	}
	
	public List<Product> getAllProducts(){
		Entity_class entity_class = new  Entity_class();
		entityManager = entity_class.getEntityManager();
		
		transaction = entityManager.getTransaction();
	        transaction.begin();
	        Query query = entityManager.createQuery("from Product");
		    List<Product> ProductList = query.getResultList();
		    transaction.commit();
		    return ProductList;
	}

	
	public List<Product> getProducts(int cid) {
	    Entity_class entity_class = new Entity_class();
	    entityManager = entity_class.getEntityManager();
	    
	    transaction = entityManager.getTransaction();
	    transaction.begin();
	    Query query = entityManager.createQuery("from Product where catagory_categoryId = :cid");
	    query.setParameter("cid", cid);
	    List<Product> ProductList = query.getResultList();
	    transaction.commit();
	    return ProductList;
	}


	
}
