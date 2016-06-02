package org.example.ppholderconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		try{
		
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"ppholderconfig.xml");

			Customer cust = (Customer) context.getBean("customer");
			System.out.println(cust.getDriverClassName());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
