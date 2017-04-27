package com.bioauth.vote;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bioauth.domain.User;


public interface BioAuthUserRepository extends CrudRepository<User, Integer>{
	
	
	public User findByAadhaaridAndDob(long aadhaarid,Date dob);
	
	
	
	
}
