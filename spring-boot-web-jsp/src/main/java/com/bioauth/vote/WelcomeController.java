package com.bioauth.vote;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bioauth.domain.User;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	@Autowired
	UserService userService;
	
	

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		User user = userService.getUser(2);
		model.put("message", this.message);
		model.put("use", user);
		return "welcome";
	}

}