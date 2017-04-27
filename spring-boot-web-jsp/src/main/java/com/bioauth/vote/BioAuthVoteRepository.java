package com.bioauth.vote;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bioauth.domain.VoteDetails;


public interface BioAuthVoteRepository extends CrudRepository<VoteDetails, Integer>{
	
	public List<VoteDetails> findAll();
	public List<VoteDetails> findByAadhaarid(long aadhaarid);
	
}
