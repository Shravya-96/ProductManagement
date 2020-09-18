package com.capgemini.controllertest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.capgemini.DeleteProductApplication;
import com.capgemini.entity.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DeleteProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTestClass {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port;
     }

     @Test
     public void contextLoads() {

     }


    @Test
    public void testDeleteProduct() {
    	int productId = 1;
         Product product = restTemplate.getForObject(getRootUrl() + "/products/" + productId, Product.class);
         assertNotNull(product);
         restTemplate.delete(getRootUrl() + "/products/" + productId);
         try {
        	 product = restTemplate.getForObject(getRootUrl() + "/products/" + productId, Product.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }


}
