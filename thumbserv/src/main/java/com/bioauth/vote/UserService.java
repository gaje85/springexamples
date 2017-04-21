package com.bioauth.vote;

import java.util.List;

import com.bioauth.domain.User;
import com.bioauth.domain.VoteDetails;

public interface UserService {
	
	public String save(User user);
	public User getUser(int id);
	public String storeVote(VoteInfo voteInfo);
	public String validate(long aadhaarId,String dob);
    public List<VoteDetails> count();
    public List<VoteDetails> findByAadhaarid(long aadhaarid);
}
