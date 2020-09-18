package com.capgemini.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.Product;

import com.capgemini.dao.DaoClass;

@Service
@Transactional
public class ServiceClass 
{
@Autowired
DaoClass dao;
public Product delete(int productId) 
{
	return dao.deleteById(productId);
}


}
