package com.example.basic;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.Ordered;


public class PostProcessTwo implements BeanPostProcessor,Ordered{

	@Resource
	ApplicationContext appContext;
	@Override
	public Object postProcessAfterInitialization(Object obj, String name)
			throws BeansException {
	
		System.out.println("Post Process Two After Name = "+name);
		return obj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String name)
			throws BeansException {
		System.out.println("Post Process Two Before Name = "+name);
		return obj;
	}

	@Override
	public int getOrder() {
		
		return Ordered.HIGHEST_PRECEDENCE;
	}

	

}
