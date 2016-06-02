package com.example.product.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.product.dao.ProductDao;
import com.example.product.model.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
	
	public void save(Product product){
		getHibernateTemplate().save(product);
	}
	
}