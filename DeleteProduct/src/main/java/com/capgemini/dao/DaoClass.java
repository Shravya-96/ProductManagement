package com.capgemini.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Product;

@Repository
public class DaoClass implements DaoInterface {
  
	@Autowired
	@PersistenceContext	
	 EntityManager entitymanager;
	

	@Override	
	public Product deleteById(int productId) {
		Product product=entitymanager.find(Product.class,productId);
		if(product!=null)
			{entitymanager.remove(product);
			}
        return product;
	}
}

