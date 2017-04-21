package com;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator{
	public boolean supports(Class clzz) {
		return Person.class.equals(clzz);
	}

	public void validate(Object obj, Errors e) {
		System.out.println("Inside /.................................");
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
		Person p = (Person) obj;
		if (p.getAge() < 0) {
			e.rejectValue("age", "negativevalue");
		} else if (p.getAge() > 110) {
			e.rejectValue("age", "tooold");
		}
	}
}
