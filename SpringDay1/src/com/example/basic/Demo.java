package com.example.basic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		try {
			// ClassPathResource resource = new 
				//	 ClassPathResource("basic.xml");
			 ClassPathXmlApplicationContext ctx = 
					 new ClassPathXmlApplicationContext("basic.xml");
			 AccountDetails accDetails = (AccountDetails)ctx.
					 getBean("accountdetails");
			 
			 accDetails.print();
			} catch (Exception e) {
			e.printStackTrace();
		}

	}
}




