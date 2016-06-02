package com.example.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.basic.CustomerInfo;

public class Demo {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfig.class);
		CustomerInfo cusInfo = (CustomerInfo) context.getBean("cusInfo");

		cusInfo.print();

	}

}
