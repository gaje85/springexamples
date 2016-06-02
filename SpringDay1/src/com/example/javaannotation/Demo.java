package com.example.javaannotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	   public static void main( String[] args )
	    {
	    	ConfigurableApplicationContext context = 
	    	  new ClassPathXmlApplicationContext(new String[] {"javaannotation.xml"});
	 
	    	CustomerService cust = (CustomerService)context.getBean("customerservice");
	 
	    	System.out.println(cust.getMessage());
	    	
	    	/*AnnoService anno = (AnnoService)context.getBean("dddd");
	    	System.out.println("testiong == "+anno);
	   */
	    		    	
	    	context.close();
	    }
	}

