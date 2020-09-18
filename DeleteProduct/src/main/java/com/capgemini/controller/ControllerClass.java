package com.capgemini.controller;
import com.capgemini.entity.Product;
import com.capgemini.service.ServiceClass;

import com.capgemini.exceptions.IdNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200")
public class ControllerClass {
	@Autowired
	ServiceClass serviceobj;

	//Deleting the particular product from the list

	@DeleteMapping("/DeleteProduct/{id}")
	private ResponseEntity<String> delEmp(@PathVariable("id") int id) {
		Product product = serviceobj.delete(id);
		if (product == null) {
			throw new IdNotFoundException("Delete Operation Unsuccessful,Provided Id does not exist");
		} else {
			return new ResponseEntity<String>("Product deleted successfully", new HttpHeaders(), HttpStatus.OK);
		}
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> userNotFound(IdNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}


}
