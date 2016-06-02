package com.example.innerbean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Demo {
	public static void main(String[] args) {
		try{
		
			ClassPathResource resource = new ClassPathResource("innerbean.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			Customer customer = (Customer)factory.getBean("customer");
			System.out.println(customer);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
