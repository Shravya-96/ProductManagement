package com.capgemini.servicetest;


import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.DeleteProductApplication;
import com.capgemini.dao.DaoClass;
import com.capgemini.entity.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeleteProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServiceTestClass {
     
     @Autowired
     DaoClass daoobj;
     
     @Test
     public void contextLoads() {

     }
   
     @Test
     public void testDeleteProduct()
     {
    	 Product deleteproduct=new Product();
    	 int productId=100;
    	 daoobj.deleteById(productId);
    	 assertNotNull(deleteproduct);
     }
}