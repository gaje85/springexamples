package com.example.product.bo.impl;

import java.util.Vector;

import com.example.product.bo.ProductBo;
import com.example.product.bo.ProductQohBo;
import com.example.product.dao.ProductDao;
import com.example.product.model.Product;
import com.example.product.model.ProductQoh;

public class ProductBoImpl implements ProductBo{
	
	ProductDao productDao;
	ProductQohBo productQohBo;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void setProductQohBo(ProductQohBo productQohBo) {
		this.productQohBo = productQohBo;
	}

	public void save(Product product, int qoh){
		
		productDao.save(product);
		System.out.println("Product Inserted");
		
		ProductQoh productQoh = new ProductQoh();
		productQoh.setProductId(product.getProductId());
		productQoh.setQty(qoh);
	
		//productQoh.setProductId(123);
		
		productQohBo.save(productQoh);
		System.out.println("ProductQoh Inserted");
		Vector v = null;
		v.add("test");
	}

}
