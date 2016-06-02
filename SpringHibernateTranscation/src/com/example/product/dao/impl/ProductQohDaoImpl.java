package com.example.product.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.example.product.dao.ProductDao;
import com.example.product.dao.ProductQohDao;
import com.example.product.model.Product;
import com.example.product.model.ProductQoh;

public class ProductQohDaoImpl extends HibernateDaoSupport implements ProductQohDao{
	
	public void save(ProductQoh productQoh){
		getHibernateTemplate().save(productQoh);
	}
	
}