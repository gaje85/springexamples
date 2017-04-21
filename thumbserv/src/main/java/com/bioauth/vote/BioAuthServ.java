package com.bioauth.vote;

import java.lang.annotation.Documented;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bioauth.domain.User;
import com.bioauth.domain.VoteDetails;

@RestController
public class BioAuthServ {
	

	@Autowired
	UserService userService;
	
	public BioAuthServ(){
		
	}
	
	@PostMapping(path="/adduser")
	public String acceptUser(@RequestBody User user){
		return userService.save(user);
		
	}
	@GetMapping(path="/finduser")
	public User findUser(@RequestParam int id){
		return userService.getUser(id);
		
	}
	@PostMapping(path="/storevote")
	public String storeVote(@RequestBody VoteInfo voteInfo){
		userService.storeVote(voteInfo);
		return "success";
	}
	@GetMapping(path="/validate")
	public String Validate(@RequestParam long aadhaarId,String dob){
		return userService.validate(aadhaarId,dob);
		
	}
	@GetMapping(path="/count")
	public Map<Integer,Long>  countVote(){
		Map<Integer,Long> countList = new HashMap<Integer,Long>();
		BiConsumer<Integer,List<VoteDetails>> biCons = (name,value) -> {
				long count = value.stream().count();
				countList.put(name, count);
		};
		List<VoteDetails> voteList = userService.count(); 
		voteList.stream().collect(Collectors.groupingBy(VoteDetails::getPartyid)).forEach(biCons);
		//voteList.stream().collect(Collectors.groupingBy(VoteDetails::getPartyid));
		System.out.println(countList);
		return countList;
	}
	@GetMapping(path="/checkvote")
	public String findByAadhaar(@RequestParam long aadhaarId){
		List<VoteDetails> list = userService.findByAadhaarid(aadhaarId);
		if(list != null && list.size() > 0){
			// vote is casted 
			return "failure";
		}else{
			return "success";
		}
	}
		
}
