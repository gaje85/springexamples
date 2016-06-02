package com.example.customer.dao.impl;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerParameterizedRowMapper;




public class SimpleJdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO
{
	//insert example
	public void insert(Customer customer){
		
		String sql = "INSERT INTO CUSTOMER " +
			"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
			 
		getJdbcTemplate().update(sql, customer.getCustId(),
					customer.getName(),customer.getAge()  
		);
			
	}
	
	//insert with named parameter
	public void insertNamedParameter(Customer customer){
		
		String sql = "INSERT INTO CUSTOMER " +
			"(CUST_ID, NAME, AGE) VALUES (:custId, :name, :age)";
		
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("custId", customer.getCustId());
		parameters.put("name", customer.getName());
		parameters.put("age", customer.getAge());
		
		getJdbcTemplate().update(sql, parameters);
			
	}
	
	
	//insert batch example
	public void insertBatch(final List<Customer> customers){
		
		String sql = "INSERT INTO CUSTOMER " +
			"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
			
		List<Object[]> parameters = new ArrayList<Object[]>();
        for (Customer cust : customers) {
            parameters.add(new Object[] {cust.getCustId(), cust.getName(), cust.getAge()});
        }
        getJdbcTemplate().batchUpdate(sql, parameters);
        
	}

	//insert batch with named parameter
	public void insertBatchNamedParameter(final List<Customer> customers){
		
		String sql = "INSERT INTO CUSTOMER " +
			"(CUST_ID, NAME, AGE) VALUES (:custId, :name, :age)";
			
		List<SqlParameterSource> parameters = new ArrayList<SqlParameterSource>();
        for (Customer cust : customers) {
        	
        	parameters.add(new BeanPropertySqlParameterSource(cust));
           
        }
        getJdbcTemplate().batchUpdate(sql,new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setLong(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setInt(3, customer.getAge() );
			}
			
			@Override
			public int getBatchSize() {
				return customers.size();
			}
		});
	}
	
	//insert batch with named parameter
	public void insertBatchNamedParameter2(final List<Customer> customers){
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(customers.toArray());
		String sql = "INSERT INTO CUSTOMER (CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
        getJdbcTemplate().batchUpdate(sql,new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Customer customer = customers.get(i);
				ps.setLong(1, customer.getCustId());
				ps.setString(2, customer.getName());
				ps.setInt(3, customer.getAge() );
			}
			
			@Override
			public int getBatchSize() {
				return customers.size();
			}
		});
    
	}
	
	//insert batch example with SQL
	public void insertBatchSQL(final String sql){
		
		getJdbcTemplate().batchUpdate(new String[]{sql});
		
	}
	
	//query single row with ParameterizedRowMapper
	public Customer findByCustomerId(int custId){
		 
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
 
		Customer customer = getJdbcTemplate().queryForObject(
				sql,  new CustomerParameterizedRowMapper(), custId);
	
		return customer;
	}
	
	//query single row with ParameterizedBeanPropertyRowMapper (Customer.class)
	public Customer findByCustomerId2(int custId){
		 
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
 
		Customer customer = getJdbcTemplate().queryForObject(
				sql,ParameterizedBeanPropertyRowMapper.newInstance(Customer.class), custId);
	
		return customer;
	}
	
	//query mutiple rows with ParameterizedBeanPropertyRowMapper (Customer.class)
	public List<Customer> findAll(){
		
		String sql = "SELECT * FROM CUSTOMER";
		 
		List<Customer> customers = 
			getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Customer.class));
		
		return customers;
	}
	
	//query mutiple rows with ParameterizedBeanPropertyRowMapper (Customer.class)
	public List<Customer> findAll2(){
		
		String sql = "SELECT * FROM CUSTOMER";
		
		List<Customer> customers = 
			getJdbcTemplate().query(sql, ParameterizedBeanPropertyRowMapper.newInstance(Customer.class));
		
		return customers;
	}
	
	public String findCustomerNameById(int custId){
		
		String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";
		 
		String name = getJdbcTemplate().queryForObject(
				sql, String.class, custId);
	
		return name;
		
	}
	
	public int findTotalCustomer(){
		
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		 
		int total = getJdbcTemplate().queryForInt(sql);
				
		return total;
	}
	
	
}
