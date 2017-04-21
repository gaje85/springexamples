package com;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.methodlookup.CommandManager;

public class HelloWorld {
	public static void main(String[] args) {
		try{
			ClassPathResource res = new 
			ClassPathResource("custompropertyeditor.xml");
			
			BeanFactory bfact = new XmlBeanFactory(res);
			
		//	Object type1 = bfact.getBean("javaVersion");
			//System.out.println("The value == "+type1);
			
			
			Calculator cal = (Calculator)bfact.getBean("cal");
			System.out.println(cal);
			System.out.println("The cal is"+cal.add(100,100)); 
			System.out.println("The cal is"+cal.sub(100,100));
			
		/*	BeanFieldValue type2 = (BeanFieldValue)bfact.getBean("FieldBean");
			System.out.println("The value == "+type2.getIsolation());
			
			DependsOnSimpleType type3 = (DependsOnSimpleType)bfact.getBean("sample");
			System.out.println("The value == "+type3);
	
			CommandManager commandManager = (CommandManager)bfact.getBean("commandManager");
			System.out.println("The value == "+commandManager.process());
	*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
