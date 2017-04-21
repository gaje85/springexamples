package com.paypal.spring.training;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class GreetingService {
	
	
	
	public GreetingService(){
		
	}
	
	@RequestMapping(value="/greet",method=RequestMethod.GET)
	public Greeting sendGreeting(){
		Greeting greeting = new Greeting();
		greeting.setName("John Thomas");
		greeting.setGreetingText("Welcome "+greeting.getName()+" to Training");
		greeting.add(linkTo(methodOn(GreetingService.class).updateGreeting()).withRel("update"));
        greeting.add(linkTo(methodOn(GreetingService.class).deleteGreeting()).withRel("delete"));

		return greeting;
	}
	@RequestMapping(value="/greetupdate")
	public Greeting updateGreeting(){
		return null;
	}
	@RequestMapping(value="/greetdelete")
	public Greeting deleteGreeting(){
		return null;
	}
}
