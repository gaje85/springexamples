package com.example.autowire;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Demo {
	public static void main(String[] args) {
		try{
		
			ClassPathResource resource = new ClassPathResource("autowire.xml");
			BeanFactory factory = new XmlBeanFactory(resource);
			Employee emp = (Employee)factory.getBean("employee");
			A a = (A)factory.getBean("a");
			System.out.println(" a == "+a.getBb());
			System.out.println("emp == "+emp.getAdd());
			Developer dev = (Developer)factory.getBean("developer");
			System.out.println("dev == "+dev.getLanguage().getName());
			//Customer cus = (Customer)factory.getBean("customer");
			//System.out.println(cus.person);
			
			
			//Customer cust = (Customer)factory.getBean("customer");
			//System.out.println(cust.getPerson().getName());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
