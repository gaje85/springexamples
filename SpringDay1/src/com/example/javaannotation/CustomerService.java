package com.example.javaannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
 
@Component
public class CustomerService
{
	//@Value("test")
	String message;
 
	public String getMessage() {
	  return message;
	}
 
	public void setMessage(String message) {
	  this.message = message;
	}
 
	@PostConstruct
	public void initIt() throws Exception {
	  System.out.println("Init method after properties are set : " + message);
	}
 
	@PreDestroy
	public void cleanUp() throws Exception {
	  System.out.println("Customer clean up");
	}
 
}