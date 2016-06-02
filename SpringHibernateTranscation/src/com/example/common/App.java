package com.example.common;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.product.bo.ProductBo;
import com.example.product.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	Product product = new Product();
    	product.setProductCode("Test");
    	product.setProductDesc("This is product of Test");
    	
    	ProductBo productBo = (ProductBo)appContext.getBean("productBoProxy");
    	productBo.save(product, 100);
    	
    	
    }
}
