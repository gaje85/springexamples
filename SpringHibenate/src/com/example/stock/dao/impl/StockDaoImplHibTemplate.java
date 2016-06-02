package com.example.stock.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.example.stock.dao.StockDao;
import com.example.stock.model.Stock;

public class StockDaoImplHibTemplate implements StockDao{
	
	private HibernateTemplate hibernateTemplate;
	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Stock stock){
		hibernateTemplate.save(stock);
	}
	
	public void update(Stock stock){
		hibernateTemplate.update(stock);
	}
	
	public void delete(Stock stock){
		hibernateTemplate.delete(stock);
		/*hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session arg0) throws HibernateException,
					SQLException {
				
				return null;
			}
		});*/
	}
	
	public Stock findByStockCode(String stockCode){
		List list = hibernateTemplate.find("from Stock where stockCode=?",stockCode);
		return (Stock)list.get(0);
	}

}
