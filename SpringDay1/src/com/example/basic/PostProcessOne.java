package com.example.basic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;


public class PostProcessOne implements BeanPostProcessor,Ordered {

	@Override
	public Object postProcessAfterInitialization(Object obj, String name)
			throws BeansException {
		
		System.out.println("Post Process One After Name = "+name);
		return obj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String name)
			throws BeansException {
		System.out.println("Post Process One Before Name = "+name);
		return obj;
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
	
}
