package com.example.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.customer.bo.CustomerBo;

public class App {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Customer.xml");

		//CustomerBo customer = (CustomerBo) appContext.getBean("customerBo");
		CustomerBo customer = appContext.getBean(CustomerBo.class);
		System.out.println(customer.getClass().getName());
		customer.addCustomer();
		
	  // customer.addCustomerThrowException();
		
		//String response = customer.addCustomerAround("example");
		//System.out.println("res from main"+response);

	}
}


class TargeClass {
	
	public void businessOne(){
		
	}
}
// subclass to the target using CGlib and then its
// overrides the method . it calls aspect first then it 
// calls super.methodName();
interface Inter{
	public void businessOne();
}
// Proxy which implements my interface and this proxy
// will call ASpect first and then my business logic
// method

class Aspect {
	public void logBefore(){
		
	}
}

class Test{
	
	int i = 100;
	public Test(){ // --> start
		// before change
		i = i++;
		//after change
	} // --> end 
	public void test(){ //---> beforemethod
	
	} //---> after
	  //---> around
	  // ---> throws 
	  // ---> throwsfinal
}









