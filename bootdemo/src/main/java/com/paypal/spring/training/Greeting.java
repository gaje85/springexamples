package com.paypal.spring.training;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

@XmlRootElement
public class Greeting extends ResourceSupport {
	
	String name;
	String greetingText;
	
	public Greeting(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreetingText() {
		return greetingText;
	}

	public void setGreetingText(String greetingText) {
		this.greetingText = greetingText;
	}
	
	

}
