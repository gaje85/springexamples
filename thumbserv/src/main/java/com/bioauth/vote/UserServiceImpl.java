package com.bioauth.vote;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bioauth.domain.User;
import com.bioauth.domain.VoteDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	BioAuthUserRepository bioAuthUserRepository;
	
	@Autowired
	BioAuthVoteRepository bioAuthVoteRepository;
	
	public UserServiceImpl(){
		
	}

	@Override
	public String save(User user) {
		bioAuthUserRepository.save(user);
		return "success";
	}

	@Override
	public User getUser(int id) {
		return bioAuthUserRepository.findOne(id);
	}

	@Override
	public String storeVote(VoteInfo voteInfo) {
		VoteDetails voteDetails = new VoteDetails();
		voteDetails.setPartyid(voteInfo.getPartyId());
		voteDetails.setAadhaarid(voteInfo.getAadhaarId());
		System.out.println("party id = "+voteInfo.getPartyId());
		System.out.println("aadhaar id = "+voteInfo.getAadhaarId());
		bioAuthVoteRepository.save(voteDetails);
		return "success";
	}

	@Override
	public String validate(long aadhaarId, String dob) {
		try{
			DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yy");
			Date date = sourceFormat.parse(dob);
			User user = bioAuthUserRepository.findByAadhaaridAndDob(aadhaarId, date);
			if(user != null){
				if(user.getAge() >= 18){
					return "success";
				}else{
					return "Age must be 18 or above";
				}
				
			}
			else
				return "failure";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public List<VoteDetails> count() {
		List<VoteDetails> list = bioAuthVoteRepository.findAll();
		return list;
	}

	@Override
	public List<VoteDetails> findByAadhaarid(long aadhaarid) {
		return bioAuthVoteRepository.findByAadhaarid(aadhaarid);
		
	}
}
