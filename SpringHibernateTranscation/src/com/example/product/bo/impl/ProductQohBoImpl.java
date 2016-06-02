package com.example.product.bo.impl;

import com.example.product.bo.ProductQohBo;
import com.example.product.dao.ProductQohDao;
import com.example.product.model.ProductQoh;

public class ProductQohBoImpl implements ProductQohBo{
	
	ProductQohDao productQohDao;
	
	public void setProductQohDao(ProductQohDao productQohDao) {
		this.productQohDao = productQohDao;
	}

	public void save(ProductQoh productQoh){
		productQohDao.save(productQoh);
	}

}
